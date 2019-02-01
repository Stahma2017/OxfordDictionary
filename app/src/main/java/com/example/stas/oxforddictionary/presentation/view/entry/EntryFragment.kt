package com.example.stas.oxforddictionary.presentation.view.entry

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.example.stas.oxforddictionary.App
import com.example.stas.oxforddictionary.R
import com.example.stas.oxforddictionary.presentation.view.entry.adapter.DefinitionAdapter
import com.example.stas.oxforddictionary.presentation.view.entry.adapter.Item
import com.example.stas.oxforddictionary.presentation.view.main.IMainActivity
import java.io.IOException
import javax.inject.Inject

class EntryFragment : Fragment(), EntryContract.View {
    @BindView(R.id.wordEntryET)
    lateinit var wordEntry: EditText
    @BindView(R.id.searchSubmitBtn)
    lateinit var searchBtn: Button
    @BindView(R.id.definition_recycler_view)
    lateinit var definitionRecyclerView: RecyclerView
    @BindView(R.id.wordInfoContainer)
    lateinit var infoContainer: LinearLayout
    @BindView(R.id.titleText)
    lateinit var word: TextView
    @BindView(R.id.titleTranscription)
    lateinit var transcription: TextView
    @BindView(R.id.titleSound)
    lateinit var soundBtn: ImageButton
    @BindView(R.id.entryProgressBar)
    lateinit var progressBar: ProgressBar
    @BindView(R.id.synonymsBtn)
    lateinit var synonymsBtn: Button
    @BindView(R.id.examplesBtn)
    lateinit var examplesBtn: Button
    private lateinit var unbinder: Unbinder
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
        unbinder = ButterKnife.bind(this, view)
        presenter.attachView(this)
        moveUp = AnimationUtils.loadAnimation(activity,
                R.anim.move_up)

        searchBtn.setOnClickListener {
            if (wordEntry.length() > 0) {
                presenter.getDefinition(wordEntry.text.toString())
                infoContainer.visibility = View.INVISIBLE
                progressBar.visibility = View.VISIBLE
            } else {
                Toast.makeText(context, "word is missing", Toast.LENGTH_SHORT).show()
            }
        }
        soundBtn.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            presenter.getSound(word.text.toString())
        }

        synonymsBtn.setOnClickListener {
            val wordId = word.text.toString()
            mainActivity!!.navigateToSynonyms(context, wordId)

        }

        examplesBtn.setOnClickListener {
            val wordId = word.text.toString()
            mainActivity!!.navigateToExamples(context, wordId)
        }
        definitionRecyclerView.layoutManager = LinearLayoutManager(context)
        definitionRecyclerView.adapter = definitionAdapter
        return view
    }

    override fun showDefinition(definitions: List<Item>, titleSet: List<String?>) {
        synonymsBtn.visibility = View.VISIBLE
        examplesBtn.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
        word.text = titleSet[0]
        transcription.text = titleSet[1]
        infoContainer.visibility = View.VISIBLE
        infoContainer.startAnimation(moveUp)
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
        Snackbar.make(infoContainer, errorMessage, Snackbar.LENGTH_SHORT).show()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mainActivity = activity as IMainActivity?
    }

    override fun onDestroyView() {
        super.onDestroyView()
        unbinder.unbind()
        presenter.detachView()
    }
}
