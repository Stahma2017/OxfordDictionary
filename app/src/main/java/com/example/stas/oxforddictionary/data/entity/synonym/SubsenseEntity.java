package com.example.stas.oxforddictionary.data.entity.synonym;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SubsenseEntity {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("synonyms")
    @Expose
    private List<SubSynonymEntity> synonyms = new ArrayList<>();;
    @SerializedName("registers")
    @Expose
    private List<String> registers = new ArrayList<>();;
    @SerializedName("regions")
    @Expose
    private List<String> regions = new ArrayList<>();;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SubSynonymEntity> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<SubSynonymEntity> synonyms) {
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
