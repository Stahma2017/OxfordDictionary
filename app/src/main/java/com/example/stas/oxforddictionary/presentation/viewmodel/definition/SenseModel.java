package com.example.stas.oxforddictionary.presentation.viewmodel.definition;

import com.example.stas.oxforddictionary.presentation.adapter.Item;
import com.example.stas.oxforddictionary.presentation.adapter.Visitor;

import java.util.ArrayList;
import java.util.List;

public class SenseModel implements Item {
    private List<String> definitions = new ArrayList<>();

    private List<ExampleModel> examples = new ArrayList<>();

    private String id;

    private List<String> shortDefinitions = new ArrayList<>();

    private List<SubsenseModel> subsens = new ArrayList<>();
    /*@SerializedName("thesaurusLinks")
    @Expose
    private List<ThesaurusLink_> thesaurusLinks = null;*/

    public List<String> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<String> definitions) {
        this.definitions = definitions;
    }

    public List<ExampleModel> getExamples() {
        return examples;
    }

    public void setExamples(List<ExampleModel> examples) {
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

    public List<SubsenseModel> getSubsens() {
        return subsens;
    }

    public void setSubsens(List<SubsenseModel> subsens) {
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
