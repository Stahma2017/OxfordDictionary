package com.example.stas.oxforddictionary.data.entity.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class LexicalEntryEntity {
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("lexicalCategory")
    @Expose
    private String lexicalCategory;
    @SerializedName("sentences")
    @Expose
    private List<SentenceEntity> sentences = new ArrayList<>();;
    @SerializedName("text")
    @Expose
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

    public List<SentenceEntity> getSentences() {
        return sentences;
    }

    public void setSentences(List<SentenceEntity> sentences) {
        this.sentences = sentences;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
