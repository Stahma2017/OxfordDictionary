package com.example.stas.oxforddictionary.data.entity.definition;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultEntity {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("language")
    @Expose
    private String language;

    @SerializedName("lexicalEntries")
    @Expose
    private List<LexicalEntryEntity> lexicalEntries = null;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("word")
    @Expose
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

    public List<LexicalEntryEntity> getLexicalEntries() {
        return lexicalEntries;
    }

    public void setLexicalEntries(List<LexicalEntryEntity> lexicalEntries) {
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
