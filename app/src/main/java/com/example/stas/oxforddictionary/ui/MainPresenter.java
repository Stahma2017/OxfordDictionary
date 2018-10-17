package com.example.stas.oxforddictionary.ui;

public class MainPresenter implements MainContract.Presenter {

    MainContract.View view;


    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void getWord(String word) {



    }
}
