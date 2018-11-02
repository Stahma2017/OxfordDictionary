package com.example.stas.oxforddictionary.presentation.view.base;

import android.content.Context;
import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import java.io.IOException;


public class BaseErrorHandler implements ErrorHandler {

    private CanShowError view;
    private Context context;

    public BaseErrorHandler() {
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
                    message = "Bad Request";
                    break;
                case 403:
                    message = "Authentication failed";
                    break;
                case 404:
                    message = "Not Found";
                    break;
                case 414:
                    message = "Request URI Too Long";
                    break;
                case 500:
                    message = "Internal Server Error";
                    break;
                case 502:
                    message = "Bad Gateway";
                    break;
                case 503:
                    message = "Service Unavailable";
                    break;
                case 504:
                    message = "Gateway timeout";
                    break;
                default:
                    message = "Server is currently experiencing issues";
                    break;
            }
        } else if (error instanceof IOException){
            message = "Network connection lost";
        }else{
            message = "unknown error";
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
