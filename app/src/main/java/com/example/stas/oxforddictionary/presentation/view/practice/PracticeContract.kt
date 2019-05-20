package com.example.stas.oxforddictionary.presentation.view.practice

import com.example.stas.oxforddictionary.data.database.model.SavedWordModel
import com.example.stas.oxforddictionary.presentation.view.base.CanShowError

interface PracticeContract {
    interface View: CanShowError{
        fun showQuiz(words: List<SavedWordModel>)
    }
    interface Presenter {
        fun detachView()
        fun attachView(view: View)
        fun getQuiz()
        fun updateWords(words: List<SavedWordModel>)
    }
}