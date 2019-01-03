package com.example.stas.oxforddictionary.data.entity.synonym;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class EntryEntity {
    @SerializedName("homographNumber")
    @Expose
    private String homographNumber;
    @SerializedName("senses")
    @Expose
    private List<SenseEntity> senses = new ArrayList<>();;

    public String getHomographNumber() {
        return homographNumber;
    }

    public void setHomographNumber(String homographNumber) {
        this.homographNumber = homographNumber;
    }

    public List<SenseEntity> getSenses() {
        return senses;
    }

    public void setSenses(List<SenseEntity> senses) {
        this.senses = senses;
    }
}
