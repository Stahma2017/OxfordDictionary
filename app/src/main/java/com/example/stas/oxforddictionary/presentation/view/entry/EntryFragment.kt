package com.example.stas.oxforddictionary.presentation.view.entry

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import com.example.stas.oxforddictionary.App
import com.example.stas.oxforddictionary.R
import com.example.stas.oxforddictionary.presentation.view.entry.adapter.DefinitionAdapter
import com.example.stas.oxforddictionary.presentation.view.entry.adapter.Item
import com.example.stas.oxforddictionary.presentation.view.main.IMainActivity
import kotlinx.android.synthetic.main.fragment_entry.*
import java.io.IOException
import javax.inject.Inject

class EntryFragment : Fragment(), EntryContract.View {

    @Inject
    lateinit var presenter: EntryContract.Presenter
    @Inject
    lateinit var definitionAdapter: DefinitionAdapter
    private var moveUp: Animation? = null
    private var mainActivity: IMainActivity? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_entry, container, false)
        (activity!!.application as App).createEntryComponent().injectEntryFragment(this)
        presenter.attachView(this)
        moveUp = AnimationUtils.loadAnimation(activity,
                R.anim.move_up)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchSubmitBtn.setOnClickListener {
            if (wordEntryET.length() > 0) {
                presenter.getDefinition(wordEntryET.text.toString())
                wordInfoContainer.visibility = View.INVISIBLE
                progressBar.visibility = View.VISIBLE
            } else {
                Toast.makeText(context, "word is missing", Toast.LENGTH_SHORT).show()
            }
        }
        soundImBtn.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            presenter.getSound(title.text.toString())
        }

        synonymsBtn.setOnClickListener {
            val wordId = title.text.toString()
            mainActivity!!.navigateToSynonyms(context, wordId)
        }

        examplesBtn.setOnClickListener {
            val wordId = title.text.toString()
            mainActivity!!.navigateToExamples(context, wordId)
        }

        definitionRW.layoutManager = LinearLayoutManager(context)
        definitionAdapter.starClickListener = { definition ->
            presenter.saveDefinition(title.text.toString(), definition)
            Toast.makeText(context, "$definition добавлен", Toast.LENGTH_SHORT).show()
        }
        definitionRW.adapter = definitionAdapter
    }

    override fun showDefinition(definitions: List<Item>, titleSet: List<String?>) {
        synonymsBtn.visibility = View.VISIBLE
        examplesBtn.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
        title.text = titleSet[0]
        transcription.text = titleSet[1]
        wordInfoContainer.visibility = View.VISIBLE
        wordInfoContainer.startAnimation(moveUp)
        definitionAdapter.setItems(definitions)
        definitionAdapter.notifyDataSetChanged()
    }

    override fun playSound(soundURL: String?) {
        val mediaPlayer = MediaPlayer()
        try {
            mediaPlayer.setDataSource(soundURL)
        } catch (e: IOException) {
            showError(getString(R.string.set_source_error))
        }
        try {
            mediaPlayer.prepare()
        } catch (e: IOException) {
            showError(getString(R.string.player_error))
        }
        mediaPlayer.start()
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun showError(errorMessage: String) {
        Snackbar.make(wordInfoContainer, errorMessage, Snackbar.LENGTH_SHORT).show()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mainActivity = activity as IMainActivity?
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }
}
