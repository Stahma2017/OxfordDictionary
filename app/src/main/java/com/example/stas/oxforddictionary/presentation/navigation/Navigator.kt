package com.example.stas.oxforddictionary.presentation.navigation

import android.content.Context
import com.example.stas.oxforddictionary.presentation.view.example.ExampleActivity
import com.example.stas.oxforddictionary.presentation.view.practice.PracticeActivity
import com.example.stas.oxforddictionary.presentation.view.synonym.SynonymActivity


class Navigator {

    fun navigateToSynonyms(context: Context?, wordId: String) {
        if (context != null) {
            val intentToLaunh = SynonymActivity.getCallingIntent(context, wordId)
            context.startActivity(intentToLaunh)
        }
    }

    fun navigateToExamples(context: Context?, wordId: String) {
        if (context != null) {
            val intentToLaunh = ExampleActivity.getCallingIntent(context, wordId)
            context.startActivity(intentToLaunh)
        }
    }

    fun navigateToPractice(context: Context?, wordId: String){
        if (context != null){
            val intentToLaunch = PracticeActivity.getCallingIntent(context, wordId)
            context.startActivity(intentToLaunch)
        }
    }
}
