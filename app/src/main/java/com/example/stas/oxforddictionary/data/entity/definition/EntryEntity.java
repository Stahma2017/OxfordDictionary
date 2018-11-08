package com.example.stas.oxforddictionary.data.entity.definition;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class EntryEntity {
    @SerializedName("etymologies")
    @Expose
    private List<String> etymologies = null;
    /*@SerializedName("grammaticalFeatures")
    @Expose
    private List<GrammaticalFeature> grammaticalFeatures = null;*/
    @SerializedName("homographNumber")
    @Expose
    private String homographNumber;
    @SerializedName("senses")
    @Expose
    private List<SenseEntity> senses = new ArrayList<>();

    public List<String> getEtymologies() {
        return etymologies;
    }

    public void setEtymologies(List<String> etymologies) {
        this.etymologies = etymologies;
    }

    /*public List<GrammaticalFeature> getGrammaticalFeatures() {
        return grammaticalFeatures;
    }

    public void setGrammaticalFeatures(List<GrammaticalFeature> grammaticalFeatures) {
        this.grammaticalFeatures = grammaticalFeatures;
    }*/

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

