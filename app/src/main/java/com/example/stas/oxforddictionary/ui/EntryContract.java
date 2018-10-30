package com.example.stas.oxforddictionary.ui;


import com.example.stas.oxforddictionary.adapter.Item;

import java.util.List;

public interface EntryContract {
    interface View{
        void showDefinition(List<Item> definitions, List<String> titleSet);
        void showToast(String msg);
        void playSound(String soundURL);
    }
    interface Presenter{
        void detachView();
        void getDefinition(String word);
        void getSound(String word);

    }
}
