package com.example.stas.oxforddictionary.data.entity.definition;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class LexicalEntryEntity {
    @SerializedName("entries")
    @Expose
    private List<EntryEntity> entries = new ArrayList<>();
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("lexicalCategory")
    @Expose
    private String lexicalCategory;
    @SerializedName("pronunciations")
    @Expose
    private List<PronunciationEntity> pronunciationEntities = null;
    @SerializedName("text")
    @Expose
    private String text;

    public List<EntryEntity> getEntries() {
        return entries;
    }

//    public void setEntries(List<Entry> entries) {
//        this.entries = entries;
//    }

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

    public List<PronunciationEntity> getPronunciationEntities() {
        return pronunciationEntities;
    }

    public void setPronunciationEntities(List<PronunciationEntity> pronunciationEntities) {
        this.pronunciationEntities = pronunciationEntities;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
