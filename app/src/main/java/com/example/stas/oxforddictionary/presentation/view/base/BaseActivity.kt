package com.example.stas.oxforddictionary.presentation.view.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.stas.oxforddictionary.presentation.navigation.Navigator

abstract class BaseActivity : AppCompatActivity() {

    protected var navigator = Navigator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
