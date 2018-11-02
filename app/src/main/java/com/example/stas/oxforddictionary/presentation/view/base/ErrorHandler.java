package com.example.stas.oxforddictionary.presentation.view.base;

public interface ErrorHandler {
    void proceed(Throwable error);
    void attachView(CanShowError view);
    void detachView();
}
