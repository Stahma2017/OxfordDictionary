package com.example.stas.oxforddictionary.presentation.view.base;

import android.content.Context;
import android.util.Log;

import com.example.stas.oxforddictionary.R;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import java.io.IOException;


public class BaseErrorHandler implements ErrorHandler {

    private CanShowError view;
    private Context context;

    public BaseErrorHandler(Context context) {
        this.context = context;
    }

    @Override
    public void proceed(Throwable error) {
        Log.d("Error", error.getMessage());
        if (view == null){
            throw new IllegalStateException("View is detached");
        }
        String message;
        if (error instanceof HttpException){
            HttpException serverError = (HttpException) error;
            switch(serverError.code()){
                case 400:
                    message = context.getString(R.string.bad_request_error);
                    break;
                case 403:
                    message = context.getString(R.string.authentication_failed_error);
                    break;
                case 404:
                    message = context.getString(R.string.not_found_error);
                    break;
                case 414:
                    message = context.getString(R.string.request_uri_too_long_error);
                    break;
                case 500:
                    message = context.getString(R.string.internal_server_error);
                    break;
                case 502:
                    message = context.getString(R.string.bad_gateway_error);
                    break;
                case 503:
                    message = context.getString(R.string.service_unavailable_error);
                    break;
                case 504:
                    message = context.getString(R.string.gateway_timeout_error);
                    break;
                default:
                    message = context.getString(R.string.server_is_currently_experiencing_issues_error);
                    break;
            }
        } else if (error instanceof IOException){
            message = context.getString(R.string.network_connection_lost_error);
        }else{
            message = context.getString(R.string.unknown_error);
        }
        view.showError(message);
    }

    @Override
    public void attachView(CanShowError view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }
}
