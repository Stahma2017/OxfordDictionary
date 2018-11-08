package com.example.stas.oxforddictionary.domain.model.definition;

import java.util.List;

public class LexicalEntry {

    private List<Entry> entries = null;

    private String language;

    private String lexicalCategory;

    private List<Pronunciation> pronunciationEntities = null;

    private String text;

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
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

    public List<Pronunciation> getPronunciationEntities() {
        return pronunciationEntities;
    }

    public void setPronunciationEntities(List<Pronunciation> pronunciationEntities) {
        this.pronunciationEntities = pronunciationEntities;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
