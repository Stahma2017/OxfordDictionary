package com.example.stas.oxforddictionary.presentation.viewmodel.example;

import java.util.List;

public class LexicalEntryModel {
    private String language;

    private String lexicalCategory;

    private List<SentenceModel> sentences = null;

    private String text;

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

    public List<SentenceModel> getSentences() {
        return sentences;
    }

    public void setSentences(List<SentenceModel> sentences) {
        this.sentences = sentences;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
