package com.example.stas.oxforddictionary.presentation.viewmodel.definition;

import com.example.stas.oxforddictionary.presentation.view.entry.adapter.Item;
import com.example.stas.oxforddictionary.presentation.view.entry.adapter.Visitor;

import java.util.List;

public class SubsenseModel implements Item {
    private List<String> definitions = null;

    private List<SubexampleModel> examples = null;

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

    public List<SubexampleModel> getExamples() {
        return examples;
    }

    public void setExamples(List<SubexampleModel> examples) {
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

    @Override
    public int getType() {
        return Item.TYPE_SUBSENSE;
    }

    @Override
    public List<String> accept(Visitor visitor) {
        return visitor.visitSubsense(this);
    }
}
