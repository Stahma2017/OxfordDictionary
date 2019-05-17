package com.example.stas.oxforddictionary.presentation.presenter.save

import com.example.stas.oxforddictionary.domain.usecase.definition.FetchSavedWordsUseCase
import com.example.stas.oxforddictionary.presentation.view.base.ErrorHandler
import com.example.stas.oxforddictionary.presentation.view.save.SaveContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SavePresenter(private val errorHandler: ErrorHandler,
                    private val compositeDisposable: CompositeDisposable,
                    private val fetchSavedWordsUseCase: FetchSavedWordsUseCase) : SaveContract.Presenter {

    private var view: SaveContract.View? = null

    override fun attachView(view: SaveContract.View) {
        this.view = view
        errorHandler.attachView(view)
    }

    override fun detachView() {
        errorHandler.detachView()
        view = null
        compositeDisposable.dispose()
    }

    override fun fetchSavedWords() {
       val savedDisp = fetchSavedWordsUseCase.fetchSavedWord()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view?.showSavedWords(it)
                },{ error -> errorHandler.proceed(error)})
        compositeDisposable.add(savedDisp)
    }
}