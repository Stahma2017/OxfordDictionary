package com.example.stas.oxforddictionary.presentation.view.synonym

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.stas.oxforddictionary.App
import com.example.stas.oxforddictionary.R
import com.example.stas.oxforddictionary.presentation.view.base.BaseActivity
import com.example.stas.oxforddictionary.presentation.view.synonym.adapter.SynonymsAdapter
import com.example.stas.oxforddictionary.presentation.view.synonym.adapter.SynonymsItem
import kotlinx.android.synthetic.main.activity_synonym.*
import javax.inject.Inject

class SynonymActivity : BaseActivity(), SynonymConrtact.View {

    @Inject
    lateinit var presenter: SynonymConrtact.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_synonym)
        (application as App).createSynonymComponent().injectSynonymActivity(this)
        presenter.attachView(this)
        val intent = intent
        val wordId = intent.getStringExtra(SYNONYM_WORD_ID)
        word.text = wordId
        presenter.getSynonyms(wordId)
    }

    override fun showSynonyms(synonyms: List<SynonymsItem>) {
        val layoutManager = LinearLayoutManager(this)
        val synonymsAdapter = SynonymsAdapter(synonyms, this)
        synonymsList.layoutManager = layoutManager
        synonymsList.adapter = synonymsAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun showError(errorMessage: String) {

    }

    fun CloseSynonymList(view: View) {
        finish()
    }

    companion object {
        private val SYNONYM_WORD_ID = "SYNONYM_WORD_ID"
        fun getCallingIntent(context: Context, wordId: String): Intent {
            val callingIntent = Intent(context, SynonymActivity::class.java)
            callingIntent.putExtra(SYNONYM_WORD_ID, wordId)
            return callingIntent
        }
    }
}
