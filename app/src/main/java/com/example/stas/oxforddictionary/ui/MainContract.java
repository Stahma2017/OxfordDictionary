package com.example.stas.oxforddictionary.ui;

public interface MainContract {

    interface View{
        void showWord(String word);
    }
    interface Presenter{
        void getWord(String word);
    }
}
