package com.example.stas.oxforddictionary.domain.Entity;

import java.util.List;

public class SubsenseEntity {

    private List<String> definitions = null;

    private List<SubExampleEntity> examples = null;

    private String id;

    private List<String> shortDefinitions = null;
    /*@SerializedName("thesaurusLinks")
    @Expose
    private List<ThesaurusLink> thesaurusLinks = null;*/

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
