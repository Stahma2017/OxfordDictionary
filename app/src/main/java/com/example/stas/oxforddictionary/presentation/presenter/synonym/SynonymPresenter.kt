package com.example.stas.oxforddictionary.presentation.presenter.synonym

import com.example.stas.oxforddictionary.domain.usecase.DefinitonInteractor
import com.example.stas.oxforddictionary.presentation.mapper.synonym.toViewModel
import com.example.stas.oxforddictionary.presentation.view.base.ErrorHandler
import com.example.stas.oxforddictionary.presentation.view.synonym.SynonymConrtact
import com.example.stas.oxforddictionary.presentation.view.synonym.adapter.SynonymsItem
import com.example.stas.oxforddictionary.presentation.viewmodel.synonym.ResultModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.ArrayList

class SynonymPresenter(private val interactor: DefinitonInteractor,
                       private val compositeDisposable: CompositeDisposable,
                       private val errorHandler: ErrorHandler) : SynonymConrtact.Presenter {

    private var view: SynonymConrtact.View? = null
    override fun getSynonyms(word: String) {
        val synonymsDisp = interactor.loadSynonyms(word)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { synonymResult -> view!!.showSynonyms(extractSynonyms(synonymResult.toViewModel()))}
        compositeDisposable.add(synonymsDisp)
    }

    override fun attachView(view: SynonymConrtact.View) {
        this.view = view
        errorHandler.attachView(view)
    }

    override fun detachView() {
        errorHandler.detachView()
        view = null
        compositeDisposable.dispose()
    }

    private fun extractSynonyms(result: ResultModel): List<SynonymsItem> {
        val synonyms = ArrayList<SynonymsItem>()
        for (lexicalEntry in result.lexicalEntries) {
            synonyms.add(lexicalEntry)
            for ((examples, _, subsenses, synonymsCopied) in lexicalEntry.entries[0].senses) {
                synonyms.addAll(examples)
                synonyms.addAll(synonymsCopied)
                for ((_, subsynonyms) in subsenses) {
                    synonyms.addAll(subsynonyms)
                }

            }
        }
        return synonyms
    }
}
