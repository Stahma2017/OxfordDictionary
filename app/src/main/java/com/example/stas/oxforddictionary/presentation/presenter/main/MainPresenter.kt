package com.example.stas.oxforddictionary.presentation.presenter.main

import com.example.stas.oxforddictionary.presentation.view.main.MainContract

class MainPresenter : MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun attachView(view: MainContract.View) {
        this.view = view
    }

    override fun dettachView() {
        view = null
    }
}
