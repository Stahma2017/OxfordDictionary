package com.example.stas.oxforddictionary.presentation.view.base

import android.content.Context
import android.util.Log
import com.example.stas.oxforddictionary.R
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import java.io.IOException


class BaseErrorHandler(private val context: Context) : ErrorHandler {

    private var view: CanShowError? = null

    override fun proceed(error: Throwable) {
        Log.d("Error", error.message)
        if (view == null) {
            throw IllegalStateException("View is detached")
        }
        val message: String = when (error) {
            is HttpException -> when (error.code()) {
                400 -> context.getString(R.string.bad_request_error)
                403 -> context.getString(R.string.authentication_failed_error)
                404 -> context.getString(R.string.not_found_error)
                414 -> context.getString(R.string.request_uri_too_long_error)
                500 -> context.getString(R.string.internal_server_error)
                502 -> context.getString(R.string.bad_gateway_error)
                503 -> context.getString(R.string.service_unavailable_error)
                504 -> context.getString(R.string.gateway_timeout_error)
                else -> context.getString(R.string.server_is_currently_experiencing_issues_error)
            }
            is IOException -> context.getString(R.string.network_connection_lost_error)
            else -> context.getString(R.string.unknown_error)
        }
        view!!.showError(message)
    }

    override fun attachView(view: CanShowError) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }
}
