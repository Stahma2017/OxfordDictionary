package com.example.stas.oxforddictionary.data.entity.synonym;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LexicalEntryEntity {
    @SerializedName("entries")
    @Expose
    private List<EntryEntity> entries = null;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("lexicalCategory")
    @Expose
    private String lexicalCategory;
    @SerializedName("text")
    @Expose
    private String text;

    public List<EntryEntity> getEntries() {
        return entries;
    }

    public void setEntries(List<EntryEntity> entries) {
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
}
