package com.example.stas.oxforddictionary.data.entity.definition;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SenseEntity {
    @SerializedName("definitions")
    @Expose
    private List<String> definitions = new ArrayList<>();
    @SerializedName("examples")
    @Expose
    private List<ExampleEntity> examples = new ArrayList<>();
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("short_definitions")
    @Expose
    private List<String> shortDefinitions = new ArrayList<>();
    @SerializedName("subsenses")
    @Expose
    private List<SubsenseEntity> subsenses = new ArrayList<>();
    /*@SerializedName("thesaurusLinks")
    @Expose
    private List<ThesaurusLink_> thesaurusLinks = null;*/

    public List<String> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<String> definitions) {
        this.definitions = definitions;
    }

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

    public List<String> getShortDefinitions() {
        return shortDefinitions;
    }

    public void setShortDefinitions(List<String> shortDefinitions) {
        this.shortDefinitions = shortDefinitions;
    }

    public List<SubsenseEntity> getSubsenses() {
        return subsenses;
    }

    public void setSubsenses(List<SubsenseEntity> subsenses) {
        this.subsenses = subsenses;
    }

   /* public List<ThesaurusLink_> getThesaurusLinks() {
        return thesaurusLinks;
    }

    public void setThesaurusLinks(List<ThesaurusLink_> thesaurusLinks) {
        this.thesaurusLinks = thesaurusLinks;
    }*/


}
