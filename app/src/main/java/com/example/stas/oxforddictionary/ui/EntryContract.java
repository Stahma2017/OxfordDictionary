package com.example.stas.oxforddictionary.ui;

import com.example.stas.oxforddictionary.data.model.Sense;

import java.util.List;

public interface EntryContract {
    interface View{
        void showDefinition(List<Sense> senses);
        void showToast(String msg);
    }
    interface Presenter{
        void detachView();
        void getDefinition(String word);

    }
}
