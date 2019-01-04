package com.example.stas.oxforddictionary.data.entity.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ExampleResponseEntity {

    @SerializedName("results")
    @Expose
    private List<ExampleResultEntity> results = new ArrayList<>();

    public List<ExampleResultEntity> getResults() {
        return results;
    }

    public void setResults(List<ExampleResultEntity> results) {
        this.results = results;
    }
}
