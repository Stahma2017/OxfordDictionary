package com.example.stas.oxforddictionary.presentation.view.practice

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.stas.oxforddictionary.R

class PracticeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice)

    }

    companion object {
        private val PRACTICE_WORD_ID = "SYNONYM_WORD_ID"
        fun getCallingIntent(context: Context, wordId: String): Intent {
            val callingIntent = Intent(context, PracticeActivity::class.java)
            callingIntent.putExtra(PRACTICE_WORD_ID, wordId)
            return callingIntent
        }
    }
}
