package com.example.stas.oxforddictionary.ui;

public interface EntryContract {
    interface View{
        void showDefinition(String definitioni);
    }
    interface Presenter{
        void detachView();
        void getDefinition(String word);

    }
}
