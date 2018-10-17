package com.example.stas.oxforddictionary.domain.Entity;

import java.util.List;

public class SenseEntity {

    private List<String> definitions = null;
    /*  @SerializedName("examples")
      @Expose
      private List<Example> examples = null;*/

    private String id;

    private List<String> shortDefinitions = null;

    private List<SubsenseEntity> subsens = null;
    /*@SerializedName("thesaurusLinks")
    @Expose
    private List<ThesaurusLink_> thesaurusLinks = null;*/

    public List<String> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<String> definitions) {
        this.definitions = definitions;
    }

   /* public List<Example> getExamples() {
        return examples;
    }

    public void setExamples(List<Example> examples) {
        this.examples = examples;
    }*/

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

    public List<SubsenseEntity> getSubsens() {
        return subsens;
    }

    public void setSubsens(List<SubsenseEntity> subsens) {
        this.subsens = subsens;
    }

   /* public List<ThesaurusLink_> getThesaurusLinks() {
        return thesaurusLinks;
    }

    public void setThesaurusLinks(List<ThesaurusLink_> thesaurusLinks) {
        this.thesaurusLinks = thesaurusLinks;
    }*/

}
