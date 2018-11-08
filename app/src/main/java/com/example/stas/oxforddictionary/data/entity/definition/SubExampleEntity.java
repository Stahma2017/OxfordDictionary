package com.example.stas.oxforddictionary.data.entity.definition;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubExampleEntity {
    @SerializedName("text")
    @Expose
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
