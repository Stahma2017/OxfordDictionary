package com.example.stas.oxforddictionary.presentation.viewmodel.synonym;


import com.example.stas.oxforddictionary.presentation.view.synonym.adapter.SynonymsItem;

import java.util.List;

public class LexicalEntryModel implements SynonymsItem {
    private List<EntryModel> entries = null;

    private String language;

    private String lexicalCategory;

    private String text;

    public List<EntryModel> getEntries() {
        return entries;
    }

    public void setEntries(List<EntryModel> entries) {
        this.entries = entries;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLexicalCategory() {
        return lexicalCategory;
    }

    public void setLexicalCategory(String lexicalCategory) {
        this.lexicalCategory = lexicalCategory;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int getType() {
        return SynonymsItem.TYPE_CATEGORY;
    }
}
