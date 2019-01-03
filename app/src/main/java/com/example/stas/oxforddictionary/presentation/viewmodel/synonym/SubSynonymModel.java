package com.example.stas.oxforddictionary.presentation.viewmodel.synonym;

import com.example.stas.oxforddictionary.presentation.view.synonym.adapter.SynonymsItem;

public class SubSynonymModel implements SynonymsItem {
    private String id;

    private String language;

    private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int getType() {
        return SynonymsItem.TYPE_SUBSYNONYM;
    }
}
