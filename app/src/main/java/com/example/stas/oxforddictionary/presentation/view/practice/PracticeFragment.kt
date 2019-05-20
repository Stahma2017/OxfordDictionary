package com.example.stas.oxforddictionary.presentation.view.practice

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.stas.oxforddictionary.App
import com.example.stas.oxforddictionary.R
import com.example.stas.oxforddictionary.data.database.model.SavedWordModel
import kotlinx.android.synthetic.main.fragment_practice.*
import java.util.*
import javax.inject.Inject


class PracticeFragment: Fragment(), PracticeContract.View, View.OnClickListener{

    @Inject
    lateinit var presenter: PracticeContract.Presenter

    private var words: List<SavedWordModel> = ArrayList()
    private var random = Random()
    private var answer: Int = 0
    private var count = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_practice, container, false)
        (activity!!.application as App).createPracticeComponent().injectPracticeFragment(this)
        presenter.attachView(this)
        presenter.getQuiz()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        option1.setOnClickListener(this)
        option2.setOnClickListener(this)
        option3.setOnClickListener(this)
        option4.setOnClickListener(this)
    }

    override fun showQuiz(words: List<SavedWordModel>) {
        this.words = words
        nextQuiz(random.nextInt(words.size))
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.option1 -> if (option1.text == words[answer].value){
                words[answer].guess ++
            }else {
                if ( words[answer].guess > 0)
                words[answer].guess --
            }
            R.id.option2 ->  if (option2.text == words[answer].value){
                words[answer].guess ++
            }else {
                if ( words[answer].guess > 0)
                words[answer].guess --
            }
            R.id.option3 ->  if (option3.text == words[answer].value){
                words[answer].guess ++
            }else {
                if ( words[answer].guess > 0)
                words[answer].guess --
            }
            R.id.option4 ->  if (option4.text == words[answer].value){
                words[answer].guess ++
            }else {
                if ( words[answer].guess > 0)
                words[answer].guess --
            }
        }
        count ++
        nextQuiz(random.nextInt(words.size))
    }

    private fun nextQuiz(n: Int){
        if (count <= 5){
            question.text = words[n].definition
            answer = n
            val options = getOptions(n)
            option1.text = options[1]
            option2.text = options[2]
            option3.text = options[3]
            option4.text = options[4]
        }
        else{
            finishQuiz()
        }
    }

    private fun getOptions(choosen: Int): List<String>{
        val options: MutableList<String> = ArrayList()
        options.add(words[choosen].value)
        var number: Int

        for (i in 0..3){
            do{
               number = random.nextInt(words.size)
            } while (options.contains(words[number].value))
            options.add(words[number].value)
        }
        options.add(random.nextInt(4)+1,words[choosen].value)
        return options
    }

    private fun finishQuiz(){
        question.text = "Quiz finished!"
        option1.visibility = View.GONE
        option2.visibility = View.GONE
        option3.visibility = View.GONE
        option4.visibility = View.GONE
        presenter.updateWords(words)
    }

    override fun showError(errorMessage: String) {
        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }
}