package com.example.stas.oxforddictionary.presentation.view.practice

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.stas.oxforddictionary.App
import com.example.stas.oxforddictionary.R
import com.example.stas.oxforddictionary.data.database.model.SavedWordModel
import com.example.stas.oxforddictionary.presentation.view.main.MainActivity
import com.example.stas.oxforddictionary.presentation.view.practice.adapter.QuizAdapter
import com.example.stas.oxforddictionary.util.ZoomOutTransformation
import kotlinx.android.synthetic.main.fragment_practice.*
import kotlinx.android.synthetic.main.layout_quiz_card.*
import kotlinx.android.synthetic.main.layout_quiz_card.view.*
import nl.dionsegijn.konfetti.models.Shape
import nl.dionsegijn.konfetti.models.Size
import java.util.*
import javax.inject.Inject


class PracticeFragment : Fragment(), PracticeContract.View, View.OnClickListener {

    companion object {
        private const val ROUND_AMOUNT = 10
        const val SAVED_WORDS_AMOUNT_ALLOWED = 8
    }

    @Inject
    lateinit var presenter: PracticeContract.Presenter
    private var words: List<SavedWordModel> = ArrayList()
    private var random = Random()
    private var answer: Int = 0
    private var count = 1
    private var results = 0

    private lateinit var quizAdapter: QuizAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_practice, container, false)
        (activity!!.application as App).createPracticeComponent().injectPracticeFragment(this)
        presenter.attachView(this)
        presenter.getQuiz()
        quizAdapter = QuizAdapter(activity)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        option1.setOnClickListener(this)
        option2.setOnClickListener(this)
        option3.setOnClickListener(this)
        option4.setOnClickListener(this)

        quizViewPager.adapter = quizAdapter
        quizViewPager.setPagingEnabled(false)
        springIndicator.setViewPager(quizViewPager)
        quizViewPager.setPageTransformer(false, ZoomOutTransformation())
        retryTest.setOnClickListener {
            (activity as MainActivity).navigateToPractice()
        }
        statisticBtn.setOnClickListener {
            (activity as MainActivity).navigateToStatistic()
        }

    }

    override fun showQuiz(words: List<SavedWordModel>) {
        this.words = words
        nextQuiz(random.nextInt(words.size))
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.option1 -> if (option1.text == words[answer].value) {
                words[answer].guess++
                results++
            } else {
                if (words[answer].guess > 0)
                    words[answer].guess--
            }
            R.id.option2 -> if (option2.text == words[answer].value) {
                words[answer].guess++
                results++
            } else {
                if (words[answer].guess > 0)
                    words[answer].guess--
            }
            R.id.option3 -> if (option3.text == words[answer].value) {
                words[answer].guess++
                results++
            } else {
                if (words[answer].guess > 0)
                    words[answer].guess--
            }
            R.id.option4 -> if (option4.text == words[answer].value) {
                words[answer].guess++
                results++
            } else {
                if (words[answer].guess > 0)
                    words[answer].guess--
            }
        }
        count++
        quizViewPager.currentItem++
        nextQuiz(random.nextInt(words.size))

    }

    private fun nextQuiz(n: Int) {
        if (count <= ROUND_AMOUNT) {
            (quizViewPager.findViewWithTag("quiz${quizViewPager.currentItem}") as View).cardQuestion.text = words[n].definition
            answer = n
            val options = getOptions(n)
            option1.text = options[1]
            option2.text = options[2]
            option3.text = options[3]
            option4.text = options[4]
        } else {
            finishQuiz()
        }
    }

    private fun getOptions(choosen: Int): List<String> {
        val options: MutableList<String> = ArrayList()
        options.add(words[choosen].value)
        var number: Int

        for (i in 0..3) {
            do {
                number = random.nextInt(words.size)
            } while (options.contains(words[number].value))
            options.add(words[number].value)
        }
        options.add(random.nextInt(4) + 1, words[choosen].value)
        return options
    }

    private fun finishQuiz() {
        quizViewPager.visibility = View.GONE
        springIndicator.visibility = View.GONE
        option1.visibility = View.GONE
        option2.visibility = View.GONE
        option3.visibility = View.GONE
        option4.visibility = View.GONE
        presenter.updateWords(words)
        val calendar = Calendar.getInstance()
        presenter.updateStatistic(results, calendar.get(Calendar.DAY_OF_WEEK))
        resultScore.visibility = View.VISIBLE
        retryTest.visibility = View.VISIBLE
        statisticBtn.visibility = View.VISIBLE
        konfetti.visibility = View.VISIBLE
        if (results == 10){
            konfetti.build()
                    .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                    .setDirection(0.0, 180.0)
                    .setSpeed(1f, 5f)
                    .setFadeOutEnabled(true)
                    .setTimeToLive(4000L)
                    .addShapes(Shape.RECT, Shape.CIRCLE)
                    .addSizes(Size(12))
                    .setPosition(500f, 500f, -100f, -100f)
                    .stream(300, 5000L)
            resultScore.text = "Вы набрали максимальный результат!"
        } else {
            resultScore.text = "Ваш результат равен $results"
        }
        results = 0
    }



    override fun showError(errorMessage: String) {
        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }
}