package com.example.stas.oxforddictionary.presentation.view.save

import com.example.stas.oxforddictionary.data.database.model.SavedWordModel
import com.example.stas.oxforddictionary.presentation.view.base.CanShowError

interface SaveContract {
    interface View: CanShowError{
        fun showSavedWords(list: List<SavedWordModel>)
    }

    interface Presenter{
        fun detachView()
        fun attachView(view: View)
        fun fetchSavedWords()
    }

}