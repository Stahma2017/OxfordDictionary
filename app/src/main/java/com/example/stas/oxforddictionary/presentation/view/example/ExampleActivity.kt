package com.example.stas.oxforddictionary.presentation.view.example

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.stas.oxforddictionary.App
import com.example.stas.oxforddictionary.R
import com.example.stas.oxforddictionary.presentation.view.example.adapter.ExampleAdapter
import kotlinx.android.synthetic.main.activity_example.*
import javax.inject.Inject

class ExampleActivity : AppCompatActivity(), ExampleContract.View {
    @Inject
    lateinit var presenter: ExampleContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)
        (application as App).createExampleComponent().injectExampleActivity(this)
        presenter.attachView(this)
        val intent = intent
        val wordId = intent.getStringExtra(EXAMPLE_WORD_ID)
        word.text = wordId
        presenter.getExamples(wordId)
    }

    override fun showExamples(examples: List<String?>) {
        val layoutManager = LinearLayoutManager(this)
        val exampleAdapter = ExampleAdapter(examples, this)
        exampleList.layoutManager = layoutManager
        exampleList.adapter = exampleAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun showError(errorMessage: String) {

    }

    fun closeExampleList(view: View) {
        finish()
    }

    companion object {

        private const val EXAMPLE_WORD_ID = "EXAMPLE_WORD_ID"

        fun getCallingIntent(context: Context, wordId: String): Intent {
            val callingIntent = Intent(context, ExampleActivity::class.java)
            callingIntent.putExtra(EXAMPLE_WORD_ID, wordId)
            return callingIntent
        }
    }
}
