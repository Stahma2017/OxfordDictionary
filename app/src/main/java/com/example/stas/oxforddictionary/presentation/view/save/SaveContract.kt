package com.example.stas.oxforddictionary.presentation.view.save

import com.example.stas.oxforddictionary.presentation.view.base.CanShowError

interface SaveContract {
    interface View: CanShowError{

    }

    interface Presenter{
        fun detachView()
        fun attachView(view: SaveContract.View)
        fun fetchSavedWords()
    }

}