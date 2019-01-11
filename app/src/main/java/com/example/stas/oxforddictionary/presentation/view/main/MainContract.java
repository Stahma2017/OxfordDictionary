package com.example.stas.oxforddictionary.presentation.view.main;

public interface MainContract {

    interface View{

    }
    interface Presenter{
        void attachView(MainContract.View view);
        void dettachView();
    }
}
