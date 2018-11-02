package com.example.stas.oxforddictionary.presentation.view.entry;


import com.example.stas.oxforddictionary.adapter.Item;
import com.example.stas.oxforddictionary.presentation.view.base.CanShowError;

import java.util.List;

public interface EntryContract {
    interface View extends CanShowError {
        void showDefinition(List<Item> definitions, List<String> titleSet);
        void playSound(String soundURL);
    }
    interface Presenter{
        void detachView();
        void getDefinition(String word);
        void getSound(String word);

    }
}
