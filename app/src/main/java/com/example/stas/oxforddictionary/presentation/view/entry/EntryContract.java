package com.example.stas.oxforddictionary.presentation.view.entry;


import com.example.stas.oxforddictionary.presentation.view.entry.adapter.Item;
import com.example.stas.oxforddictionary.presentation.view.base.CanShowError;

import java.util.List;

public interface EntryContract {
    interface View extends CanShowError {
        void showDefinition(List<Item> definitions, List<String> titleSet);
        void playSound(String soundURL);
        void hideProgressBar();
    }
    interface Presenter{
        void detachView();
        void attachView(EntryContract.View view);
        void getDefinition(String word);
        void getSound(String word);


    }
}
