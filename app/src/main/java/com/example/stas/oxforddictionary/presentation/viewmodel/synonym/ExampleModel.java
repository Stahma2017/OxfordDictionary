package com.example.stas.oxforddictionary.presentation.viewmodel.synonym;

import com.example.stas.oxforddictionary.presentation.view.synonym.adapter.SynonymsItem;

public class ExampleModel implements SynonymsItem {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int getType() {
        return SynonymsItem.TYPE_EXAMPLE;
    }
}
