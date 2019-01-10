package com.example.stas.oxforddictionary.presentation.presenter.main;

import com.example.stas.oxforddictionary.presentation.view.main.MainContract;

public class MainPresenter implements MainContract.Presenter {

    MainContract.View view;


    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

}
