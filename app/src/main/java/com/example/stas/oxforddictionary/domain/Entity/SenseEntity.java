package com.example.stas.oxforddictionary.domain.Entity;

import com.example.stas.oxforddictionary.adapter.Item;
import com.example.stas.oxforddictionary.adapter.Visitor;

import java.util.ArrayList;
import java.util.List;

public class SenseEntity implements Item {

    private List<String> definitions = new ArrayList<>();

      private List<ExampleEntity> examples = new ArrayList<>();

    private String id;

    private List<String> shortDefinitions = new ArrayList<>();

    private List<SubsenseEntity> subsens = new ArrayList<>();
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

    @Override
    public List<String> accept(Visitor visitor) {
        return visitor.visitSense(this);
    }

    @Override
    public int getType() {
        return Item.TYPE_SENSE;
    }
}
