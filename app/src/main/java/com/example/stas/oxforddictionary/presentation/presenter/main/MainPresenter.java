package com.example.stas.oxforddictionary.presentation.presenter.main;

import com.example.stas.oxforddictionary.presentation.view.main.MainContract;

public class MainPresenter implements MainContract.Presenter {

   private MainContract.View view;


    public MainPresenter() {
    }

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void dettachView() {
        view = null;
    }
}
