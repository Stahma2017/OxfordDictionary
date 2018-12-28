package com.example.stas.oxforddictionary.data.entity.synonym;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SenseEntity {
    @SerializedName("examples")
    @Expose
    private List<ExampleEntity> examples = null;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("subsenses")
    @Expose
    private List<SubsenseEntity> subsenses = null;
    @SerializedName("synonyms")
    @Expose
    private List<SynonymEntity> synonyms = null;

    public List<ExampleEntity> getExamples() {
        return examples;
    }

    public void setExamples(List<ExampleEntity> examples) {
        this.examples = examples;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SubsenseEntity> getSubsenses() {
        return subsenses;
    }

    public void setSubsenses(List<SubsenseEntity> subsenses) {
        this.subsenses = subsenses;
    }

    public List<SynonymEntity> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<SynonymEntity> synonyms) {
        this.synonyms = synonyms;
    }
}
