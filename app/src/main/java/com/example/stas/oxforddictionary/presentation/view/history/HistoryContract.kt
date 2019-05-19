package com.example.stas.oxforddictionary.presentation.view.history

import com.example.stas.oxforddictionary.presentation.view.base.CanShowError

interface HistoryContract {
    interface View: CanShowError{

    }

    interface Presenter{
        fun detachView()
        fun attachView(view: View)
    }
}