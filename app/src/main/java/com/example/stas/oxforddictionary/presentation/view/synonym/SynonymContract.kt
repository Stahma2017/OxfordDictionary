package com.example.stas.oxforddictionary.presentation.view.synonym

import com.example.stas.oxforddictionary.presentation.view.base.CanShowError
import com.example.stas.oxforddictionary.presentation.view.synonym.adapter.SynonymsItem

interface SynonymConrtact {
    interface View : CanShowError {
        fun showSynonyms(synonyms: List<SynonymsItem>)
    }

    interface Presenter {
        fun attachView(view: SynonymConrtact.View)
        fun detachView()
        fun getSynonyms(word: String)
    }
}
