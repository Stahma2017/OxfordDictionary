package com.example.stas.oxforddictionary.presentation.viewmodel.synonym;

import java.util.List;

public class EntryModel {
    private String homographNumber;

    private List<SenseModel> senses = null;

    public String getHomographNumber() {
        return homographNumber;
    }

    public void setHomographNumber(String homographNumber) {
        this.homographNumber = homographNumber;
    }

    public List<SenseModel> getSenses() {
        return senses;
    }

    public void setSenses(List<SenseModel> senses) {
        this.senses = senses;
    }
}
