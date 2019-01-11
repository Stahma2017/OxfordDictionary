package com.example.stas.oxforddictionary.di.main;

import com.example.stas.oxforddictionary.presentation.presenter.main.MainPresenter;
import com.example.stas.oxforddictionary.presentation.view.main.MainContract;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    @Provides
    public MainContract.Presenter provideMainPresenter(){
        return new MainPresenter();
    }
}
