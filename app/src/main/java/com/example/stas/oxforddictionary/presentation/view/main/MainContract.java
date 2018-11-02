package com.example.stas.oxforddictionary.presentation.view.main;

public interface MainContract {

    interface View{
        void showWord(String word);
    }
    interface Presenter{
        void getWord(String word);
    }
}
