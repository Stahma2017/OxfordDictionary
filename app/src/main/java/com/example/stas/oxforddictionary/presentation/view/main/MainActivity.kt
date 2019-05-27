package com.example.stas.oxforddictionary.presentation.view.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.view.View
import android.widget.TextView
import com.example.stas.oxforddictionary.App
import com.example.stas.oxforddictionary.R
import com.example.stas.oxforddictionary.presentation.view.base.BaseActivity
import com.example.stas.oxforddictionary.presentation.view.entry.EntryFragment
import com.example.stas.oxforddictionary.presentation.view.practice.PracticeFragment
import com.example.stas.oxforddictionary.presentation.view.save.SaveFragment
import com.example.stas.oxforddictionary.presentation.view.statistic.StatisticFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View, IMainActivity {

    private var allWordsCount: TextView? = null
    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as App).createMaincomponent().injectMainActivity(this)
        presenter.attachView(this)
        init()

        navView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            drawer.closeDrawers()
            inflateFragment(menuItem.title.toString())
            true
        }
    }

    private fun inflateFragment(fragmentTag: String, message: String = "")  {
        when(fragmentTag){
            getString(R.string.menu_search).toString() -> doFragmentTransaction(EntryFragment(), fragmentTag, false, message)
            getString(R.string.menu_search_history).toString() -> Unit
            getString(R.string.menu_training).toString() ->  doFragmentTransaction(PracticeFragment(), fragmentTag, false, message)
            getString(R.string.menu_saved).toString() ->   doFragmentTransaction(SaveFragment(), fragmentTag, false, message)
            getString(R.string.menu_settings).toString() -> doFragmentTransaction(StatisticFragment(),fragmentTag, false, message)
            getString(R.string.menu_author_about).toString() -> sendToAuthor()
            else -> throw RuntimeException("Something went wrong")
        }
    }

    private fun sendToAuthor(){
        val emailIntent = Intent(Intent.ACTION_SEND)
        emailIntent.type = "text/plain"
        emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("StasStahmaJob@gmail.com"))
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Отклик Пользователя")
        startActivity(Intent.createChooser(emailIntent, "Send Email..."))
    }



    private fun init() {
        val entryFragment = EntryFragment()
        doFragmentTransaction(entryFragment, getString(R.string.fragment_entry), false, "")
        allWordsCount = navView.getHeaderView(0).findViewById(R.id.allWordsCount)
    }



    private fun doFragmentTransaction(fragment: Fragment, tag: String, addToBackStack: Boolean, message: String) {
        val transaction = supportFragmentManager.beginTransaction()
        if (message != "") {
            val bundle = Bundle()
            bundle.putString(getString(R.string.intent_message), message)
            fragment.arguments = bundle
        }
        transaction.replace(R.id.content_frame, fragment, tag)
        if (addToBackStack) {
            transaction.addToBackStack(tag)
        }
        transaction.commit()
    }

    override fun navigateToSynonyms(context: Context?, wordId: String) {
        navigator.navigateToSynonyms(context, wordId)
    }

    override fun navigateToExamples(context: Context?, wordId: String) {
        navigator.navigateToExamples(context, wordId)
    }

    override fun navigateToPractice(context: Context?, wordId: String) {
        navigator.navigateToPractice(context, wordId)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dettachView()
    }

    fun openDrawer(view: View) {
        drawer.openDrawer(GravityCompat.START)
    }
}
