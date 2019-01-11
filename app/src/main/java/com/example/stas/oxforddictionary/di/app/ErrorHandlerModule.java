package com.example.stas.oxforddictionary.di.app;

import android.content.Context;

import com.example.stas.oxforddictionary.presentation.view.base.BaseErrorHandler;
import com.example.stas.oxforddictionary.presentation.view.base.ErrorHandler;

import dagger.Module;
import dagger.Provides;

@Module
public class ErrorHandlerModule {
    @Provides
    public ErrorHandler provideErrorHandler(Context context){
        return new BaseErrorHandler(context);
    }
}
