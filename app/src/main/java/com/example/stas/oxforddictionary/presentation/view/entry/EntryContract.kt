package com.example.stas.oxforddictionary.presentation.view.entry

import com.example.stas.oxforddictionary.presentation.view.base.CanShowError
import com.example.stas.oxforddictionary.presentation.view.entry.adapter.Item

interface EntryContract {
    interface View : CanShowError {
        fun showDefinition(definitions: List<Item>, titleSet: List<String?>)
        fun playSound(soundURL: String?)
        fun hideProgressBar()
    }

    interface Presenter {
        fun detachView()
        fun attachView(view: EntryContract.View)
        fun getDefinition(word: String)
        fun getSound(word: String)
        fun saveDefinition(word: String, definition: String)
    }
}
