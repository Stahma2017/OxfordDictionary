package com.example.stas.oxforddictionary.data.entity.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SentenceEntity {
    @SerializedName("definitions")
    @Expose
    private List<String> definitions = new ArrayList<>();;
    @SerializedName("domains")
    @Expose
    private List<String> domains = new ArrayList<>();;
    @SerializedName("regions")
    @Expose
    private List<String> regions = new ArrayList<>();;
    @SerializedName("registers")
    @Expose
    private List<String> registers = new ArrayList<>();;
    @SerializedName("senseIds")
    @Expose
    private List<String> senseIds = new ArrayList<>();;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("translations")
    @Expose
    private List<TranslationEntity> translations = new ArrayList<>();;

    public List<String> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<String> definitions) {
        this.definitions = definitions;
    }

    public List<String> getDomains() {
        return domains;
    }

    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    public List<String> getRegions() {
        return regions;
    }

    public void setRegions(List<String> regions) {
        this.regions = regions;
    }

    public List<String> getRegisters() {
        return registers;
    }

    public void setRegisters(List<String> registers) {
        this.registers = registers;
    }

    public List<String> getSenseIds() {
        return senseIds;
    }

    public void setSenseIds(List<String> senseIds) {
        this.senseIds = senseIds;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<TranslationEntity> getTranslations() {
        return translations;
    }

    public void setTranslations(List<TranslationEntity> translations) {
        this.translations = translations;
    }
}
