package com.example.stas.oxforddictionary.presentation.viewmodel.definition;


import java.util.List;

public class LexicalEntryModel {
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
}
