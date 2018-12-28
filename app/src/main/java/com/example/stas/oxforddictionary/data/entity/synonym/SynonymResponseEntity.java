package com.example.stas.oxforddictionary.data.entity.synonym;

import com.example.stas.oxforddictionary.data.entity.definition.MetadataEntity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SynonymResponseEntity {
    @SerializedName("metadata")
    @Expose
    private MetadataEntity metadata;
    @SerializedName("results")
    @Expose
    private List<ResultEntity> results = null;

    public MetadataEntity getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataEntity metadata) {
        this.metadata = metadata;
    }

    public List<ResultEntity> getResults() {
        return results;
    }

    public void setResults(List<ResultEntity> results) {
        this.results = results;
    }
}
