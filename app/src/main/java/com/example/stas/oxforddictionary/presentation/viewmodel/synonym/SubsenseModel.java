package com.example.stas.oxforddictionary.presentation.viewmodel.synonym;

import java.util.List;

public class SubsenseModel {
    private String id;

    private List<SubSynonymModel> synonyms = null;

    private List<String> registers = null;

    private List<String> regions = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SubSynonymModel> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<SubSynonymModel> synonyms) {
        this.synonyms = synonyms;
    }

    public List<String> getRegisters() {
        return registers;
    }

    public void setRegisters(List<String> registers) {
        this.registers = registers;
    }

    public List<String> getRegions() {
        return regions;
    }

    public void setRegions(List<String> regions) {
        this.regions = regions;
    }
}
