package com.example.stas.oxforddictionary.ui;

import butterknife.Unbinder;

public class EntryPresenter implements EntryContract.Presenter {
    EntryContract.View view;

    public EntryPresenter(EntryContract.View view) {
        this.view = view;
    }
}
