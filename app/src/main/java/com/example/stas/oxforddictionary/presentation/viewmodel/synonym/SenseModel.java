package com.example.stas.oxforddictionary.presentation.viewmodel.synonym;

import java.util.List;

public class SenseModel {
    private List<ExampleModel> examples = null;

    private String id;

    private List<SubsenseModel> subsenses = null;

    private List<SynonymModel> synonyms = null;

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

    public List<SubsenseModel> getSubsenses() {
        return subsenses;
    }

    public void setSubsenses(List<SubsenseModel> subsenses) {
        this.subsenses = subsenses;
    }

    public List<SynonymModel> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<SynonymModel> synonyms) {
        this.synonyms = synonyms;
    }
}
