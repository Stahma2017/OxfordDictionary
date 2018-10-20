package com.example.stas.oxforddictionary.ui;


import com.example.stas.oxforddictionary.adapter.Item;

import java.util.List;

public interface EntryContract {
    interface View{
        void showDefinition(List<Item> definitions);
        void showToast(String msg);
    }
    interface Presenter{
        void detachView();
        void getDefinition(String word);

    }
}
