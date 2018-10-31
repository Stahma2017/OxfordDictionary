package com.example.stas.oxforddictionary.ui.base;

public interface ErrorHandler {
    void proceed(Throwable error);
    void attachView(CanShowError view);
    void detachView();
}
