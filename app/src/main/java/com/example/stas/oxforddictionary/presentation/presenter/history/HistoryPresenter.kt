package com.example.stas.oxforddictionary.presentation.presenter.history

import com.example.stas.oxforddictionary.presentation.view.base.ErrorHandler
import com.example.stas.oxforddictionary.presentation.view.history.HistoryContract
import io.reactivex.disposables.CompositeDisposable

class HistoryPresenter(private val compositeDisposable: CompositeDisposable,
                       private val errorHandler: ErrorHandler) : HistoryContract.Presenter {

    private var view: HistoryContract.View? = null

    override fun attachView(view: HistoryContract.View) {
        this.view = view
        errorHandler.attachView(view)
    }

    override fun detachView() {
        errorHandler.detachView()
        view = null
        compositeDisposable.dispose()
    }


}