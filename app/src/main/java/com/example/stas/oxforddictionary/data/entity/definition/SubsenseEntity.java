package com.example.stas.oxforddictionary.data.entity.definition;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SubsenseEntity {
    @SerializedName("definitions")
    @Expose
    private List<String> definitions = new ArrayList<>();
    @SerializedName("examples")
    @Expose
    private List<SubExampleEntity> examples = new ArrayList<>();
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("short_definitions")
    @Expose
    private List<String> shortDefinitions = null;
    /*@SerializedName("thesaurusLinks")
    @Expose
    private List<ThesaurusLink> thesaurusLinks = null;*/
    @SerializedName("domains")
    @Expose
    private List<String> domains = null;

    public List<String> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<String> definitions) {
        this.definitions = definitions;
    }

    public List<SubExampleEntity> getExamples() {
        return examples;
    }

    public void setExamples(List<SubExampleEntity> examples) {
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

    /*public List<ThesaurusLink> getThesaurusLinks() {
        return thesaurusLinks;
    }

    public void setThesaurusLinks(List<ThesaurusLink> thesaurusLinks) {
        this.thesaurusLinks = thesaurusLinks;
    }*/

    public List<String> getDomains() {
        return domains;
    }

    public void setDomains(List<String> domains) {
        this.domains = domains;
    }
}
