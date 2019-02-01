package com.example.stas.oxforddictionary.presentation.view.base

interface ErrorHandler {
    fun proceed(error: Throwable)
    fun attachView(view: CanShowError)
    fun detachView()
}
