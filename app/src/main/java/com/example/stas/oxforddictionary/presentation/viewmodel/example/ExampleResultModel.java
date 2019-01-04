package com.example.stas.oxforddictionary.presentation.viewmodel.example;

import java.util.List;

public class ExampleResultModel {
    private String id;

    private String language;

    private List<LexicalEntryModel> lexicalEntries = null;

    private String type;

    private String word;

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

    public List<LexicalEntryModel> getLexicalEntries() {
        return lexicalEntries;
    }

    public void setLexicalEntries(List<LexicalEntryModel> lexicalEntries) {
        this.lexicalEntries = lexicalEntries;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
