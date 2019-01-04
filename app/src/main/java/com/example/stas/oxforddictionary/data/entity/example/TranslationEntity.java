package com.example.stas.oxforddictionary.data.entity.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TranslationEntity {
    @SerializedName("domains")
    @Expose
    private List<String> domains = new ArrayList<>();;

    @SerializedName("language")
    @Expose
    private String language;

    @SerializedName("regions")
    @Expose
    private List<String> regions = new ArrayList<>();;
    @SerializedName("registers")
    @Expose
    private List<String> registers = new ArrayList<>();;
    @SerializedName("text")
    @Expose
    private String text;

    public List<String> getDomains() {
        return domains;
    }

    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
