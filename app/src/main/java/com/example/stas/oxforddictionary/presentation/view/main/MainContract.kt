package com.example.stas.oxforddictionary.presentation.view.main

interface MainContract {

    interface View
    interface Presenter {
        fun attachView(view: MainContract.View)
        fun dettachView()
    }
}
