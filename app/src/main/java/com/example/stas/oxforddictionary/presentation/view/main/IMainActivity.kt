package com.example.stas.oxforddictionary.presentation.view.main

import android.content.Context

interface IMainActivity {
    fun navigateToSynonyms(context: Context?, wordId: String)
    fun navigateToExamples(context: Context?, wordId: String)
    fun navigateToPractice(context: Context?, wordId: String)
}
