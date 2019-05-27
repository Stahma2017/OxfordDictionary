package com.example.stas.oxforddictionary.presentation.view.entry

import com.example.stas.oxforddictionary.data.database.model.ViewedWordModel
import com.example.stas.oxforddictionary.presentation.view.base.CanShowError
import com.example.stas.oxforddictionary.presentation.view.entry.adapter.Item
import io.reactivex.Flowable
import io.reactivex.Observable

interface EntryContract {
    interface View : CanShowError {
        fun showDefinition(definitions: List<Item>, titleSet: List<String?>)
        fun playSound(soundURL: String?)
        fun hideProgressBar()
       fun showAutocompletes(t: List<String>?)
    }

    interface Presenter {
        fun detachView()
        fun attachView(view: EntryContract.View)
        fun getDefinition(word: String)
        fun getSound(word: String)
        fun saveDefinition(word: String, definition: String)
        fun onEntryTextChanged(text: String): Observable<List<ViewedWordModel>>
    }
}
