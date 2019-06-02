package com.example.stas.oxforddictionary.presentation.view.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import com.example.stas.oxforddictionary.presentation.navigation.Navigator

abstract class BaseActivity : AppCompatActivity() {

    protected var navigator = Navigator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun closeKeyboard(){
        val view = currentFocus
        view.let {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view!!.windowToken, 0)
        }

    }
}
