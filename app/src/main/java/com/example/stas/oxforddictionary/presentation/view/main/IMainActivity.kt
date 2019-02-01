package com.example.stas.oxforddictionary.presentation.view.main

import android.content.Context

interface IMainActivity {
    fun inflateFragment(fragmentTag: String, word: String)
    fun navigateToSynonyms(context: Context?, wordId: String)
    fun navigateToExamples(context: Context?, wordId: String)
}
