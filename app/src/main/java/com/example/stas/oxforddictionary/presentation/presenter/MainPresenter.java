package com.example.stas.oxforddictionary.presentation.presenter;

import com.example.stas.oxforddictionary.presentation.view.main.MainContract;

public class MainPresenter implements MainContract.Presenter {

    MainContract.View view;


    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void getWord(String word) {



    }
}