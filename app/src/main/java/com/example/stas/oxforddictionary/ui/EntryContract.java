package com.example.stas.oxforddictionary.ui;

import java.util.List;

public interface EntryContract {
    interface View{
        void showDefinition(List<String> definitions, String word, String soundURL);
    }
    interface Presenter{
        void detachView();
        void getDefinition(String word);

    }
}
