package com.example.stas.oxforddictionary.presentation.view.example

import com.example.stas.oxforddictionary.presentation.view.base.CanShowError

interface ExampleContract {
    interface View : CanShowError {
        fun showExamples(examples: List<String?>)
    }

    interface Presenter {
        fun attachView(view: ExampleContract.View)
        fun getExamples(word: String)
        fun detachView()
    }

}
