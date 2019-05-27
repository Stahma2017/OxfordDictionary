package com.example.stas.oxforddictionary.presentation.presenter.entry

import com.example.stas.oxforddictionary.data.database.model.SavedWordModel
import com.example.stas.oxforddictionary.data.database.model.ViewedWordModel
import com.example.stas.oxforddictionary.domain.usecase.DefinitonInteractor
import com.example.stas.oxforddictionary.domain.usecase.definition.SaveToViewedUseCase
import com.example.stas.oxforddictionary.domain.usecase.definition.SaveWordUseCase
import com.example.stas.oxforddictionary.domain.usecase.definition.SearchViewedWordsUseCase
import com.example.stas.oxforddictionary.presentation.mapper.definition.toViewModel
import com.example.stas.oxforddictionary.presentation.view.base.ErrorHandler
import com.example.stas.oxforddictionary.presentation.view.entry.EntryContract
import com.example.stas.oxforddictionary.presentation.view.entry.adapter.Item
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.ResultModel
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import java.util.*
import java.util.concurrent.TimeUnit


class EntryPresenter(private val interactor: DefinitonInteractor, private val compositeDisposable: CompositeDisposable,
                     private val errorHandler: ErrorHandler, private val saveWordUseCase: SaveWordUseCase,
                     private val saveToViewedUseCase: SaveToViewedUseCase,
                     private val searchViewedWordsUseCase: SearchViewedWordsUseCase) : EntryContract.Presenter {
    private var view: EntryContract.View? = null
    private var subject: PublishSubject<String>? = null

    override fun attachView(view: EntryContract.View) {
        this.view = view
        errorHandler.attachView(view)
        subject = PublishSubject.create<String>()
    }

    override fun detachView() {
        errorHandler.detachView()
        view = null
        compositeDisposable.dispose()
    }

    override fun getDefinition(word: String) {
        val definitionDisp = interactor.loadDefinition(word)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    val resultModel = result.toViewModel()
                    view!!.showDefinition(extractDefinitions(resultModel), extractTitle(resultModel))
                    saveToViewed(word)
                }, { throwable ->
                    view!!.hideProgressBar()
                    errorHandler.proceed(throwable)
                })
        compositeDisposable.add(definitionDisp)
    }

    private fun saveToViewed(word: String) {
        val saveViewedDisp = saveToViewedUseCase.saveWord(ViewedWordModel(word = word))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ view?.showError("Saved") },
                        { throwable -> errorHandler.proceed(throwable) })
        compositeDisposable.addAll(saveViewedDisp)
    }

    override fun getSound(word: String) {
        val soundDisp = interactor.loadDefinition(word)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ (_, _, lexicalEntries) ->
                    view!!.playSound(lexicalEntries[0].pronunciations[0].audioFile)
                }, { throwable -> errorHandler.proceed(throwable) })
        compositeDisposable.add(soundDisp)
    }

    override fun saveDefinition(word: String, definition: String) {
        val saveWordDisp = saveWordUseCase.saveWord(SavedWordModel(value = word, definition = definition, guess = 0))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view?.showError("DONE!")
                },
                        { throwable ->
                            errorHandler.proceed(throwable)
                        })
        compositeDisposable.add(saveWordDisp)
    }

    override fun onEntryTextChanged(text: String) = searchViewedWordsUseCase.searchViewedWords("$text%")

    private fun extractDefinitions(result: ResultModel): List<Item> {
        val definitions = ArrayList<Item>()
        for (lexicalEntry in result.lexicalEntries) {
            definitions.add(lexicalEntry)
            for (sense in lexicalEntry.entries[0].senses) {
                if (!sense.definitions!!.isEmpty()) {
                    definitions.add(sense)
                    for (subsense in sense.subsenses) {
                        if (!subsense.definitions!!.isEmpty()) {
                            definitions.add(subsense)
                        }
                    }
                }
            }
        }
        return definitions
    }

    private fun extractTitle(result: ResultModel): List<String?> {
        val (_, _, _, pronunciations, text) = result.lexicalEntries[0]
        val titleSet = ArrayList<String?>()
        titleSet.add(text)
        for ((audioFile, _, _, phoneticSpelling) in pronunciations) {
            if (audioFile != null) {
                titleSet.add("[$phoneticSpelling]")
            }
        }
        return titleSet
    }
}

