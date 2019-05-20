package com.example.stas.oxforddictionary.presentation.presenter.practice

import com.example.stas.oxforddictionary.data.database.model.SavedWordModel
import com.example.stas.oxforddictionary.domain.usecase.definition.FetchSavedWordsUseCase
import com.example.stas.oxforddictionary.domain.usecase.definition.UpdateSavedWordsUseCase
import com.example.stas.oxforddictionary.presentation.view.base.ErrorHandler
import com.example.stas.oxforddictionary.presentation.view.practice.PracticeContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PracticePresenter(private val errorHandler: ErrorHandler,
                        private val compositeDisposable: CompositeDisposable,
                        private val fetchSavedWordsUseCase: FetchSavedWordsUseCase,
                        private val updateSavedWordsUseCase: UpdateSavedWordsUseCase) : PracticeContract.Presenter {

    private var view: PracticeContract.View? = null


    override fun attachView(view: PracticeContract.View) {
        this.view = view
        errorHandler.attachView(view)
    }

    override fun detachView() {
        errorHandler.detachView()
        view = null
        compositeDisposable.dispose()
    }

    override fun getQuiz() {
        val quizDisp = fetchSavedWordsUseCase.fetchSavedWord()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    startQuiz(it)
                }, { error -> errorHandler.proceed(error) })
        compositeDisposable.add(quizDisp)
    }

    override fun updateWords(words: List<SavedWordModel>) {
        val updateWordsDisp = updateSavedWordsUseCase.updateWords(words)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view?.showError("Done")
                }, { throwable ->
                    errorHandler.proceed(throwable)
                })
        compositeDisposable.add(updateWordsDisp)
    }

    private fun isCountEnough(words: List<SavedWordModel>) =
            words.size >= 10


    private fun startQuiz(words: List<SavedWordModel>) {
        if (isCountEnough(words)) {
            view?.showQuiz(words)
        }
    }


}