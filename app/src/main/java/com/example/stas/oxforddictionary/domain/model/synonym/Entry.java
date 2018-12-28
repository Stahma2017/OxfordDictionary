package com.example.stas.oxforddictionary.domain.model.synonym;

import java.util.List;

public class Entry {

    private String homographNumber;

    private List<Sense> senses = null;

    public String getHomographNumber() {
        return homographNumber;
    }

    public void setHomographNumber(String homographNumber) {
        this.homographNumber = homographNumber;
    }

    public List<Sense> getSenses() {
        return senses;
    }

    public void setSenses(List<Sense> senses) {
        this.senses = senses;
    }
}
