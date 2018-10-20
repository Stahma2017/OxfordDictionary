package com.example.stas.oxforddictionary.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Sense {
    @SerializedName("definitions")
    @Expose
    private List<String> definitions = new ArrayList<>();
    @SerializedName("examples")
    @Expose
    private List<Example> examples = new ArrayList<>();
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("short_definitions")
    @Expose
    private List<String> shortDefinitions = new ArrayList<>();
    @SerializedName("subsenses")
    @Expose
    private List<Subsense> subsenses = new ArrayList<>();
    /*@SerializedName("thesaurusLinks")
    @Expose
    private List<ThesaurusLink_> thesaurusLinks = null;*/

    public List<String> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<String> definitions) {
        this.definitions = definitions;
    }

    public List<Example> getExamples() {
        return examples;
    }

    public void setExamples(List<Example> examples) {
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

    public List<Subsense> getSubsenses() {
        return subsenses;
    }

    public void setSubsenses(List<Subsense> subsenses) {
        this.subsenses = subsenses;
    }

   /* public List<ThesaurusLink_> getThesaurusLinks() {
        return thesaurusLinks;
    }

    public void setThesaurusLinks(List<ThesaurusLink_> thesaurusLinks) {
        this.thesaurusLinks = thesaurusLinks;
    }*/


}
