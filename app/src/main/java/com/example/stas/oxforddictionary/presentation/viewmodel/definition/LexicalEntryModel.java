package com.example.stas.oxforddictionary.presentation.viewmodel.definition;


import com.example.stas.oxforddictionary.presentation.adapter.Item;
import com.example.stas.oxforddictionary.presentation.adapter.Visitor;

import java.util.List;

public class LexicalEntryModel implements Item {
    private List<EntryModel> entries = null;

    private String language;

    private String lexicalCategory;

    private List<PronunciationModel> pronunciationEntities = null;

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

    public List<PronunciationModel> getPronunciationEntities() {
        return pronunciationEntities;
    }

    public void setPronunciationEntities(List<PronunciationModel> pronunciationEntities) {
        this.pronunciationEntities = pronunciationEntities;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int getType() {
        return Item.TYPE_HEADER;
    }

    @Override
    public List<String> accept(Visitor visitor) {
        return null;
    }
}
