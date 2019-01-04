package com.example.stas.oxforddictionary.presentation.viewmodel.example;

import java.util.List;

public class SentenceModel {
    private List<String> definitions = null;

    private List<String> domains = null;

    private List<String> regions = null;

    private List<String> registers = null;

    private List<String> senseIds = null;

    private String text;

    private List<TranslationModel> translations = null;

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

    public List<TranslationModel> getTranslations() {
        return translations;
    }

    public void setTranslations(List<TranslationModel> translations) {
        this.translations = translations;
    }
}
