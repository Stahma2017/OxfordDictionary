package com.example.stas.oxforddictionary.di.app;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Context appContext;

    public AppModule(Context appContext) {
        this.appContext = appContext;
    }

    @Provides
    public Context provideContext(){
        return appContext;
    }
}
