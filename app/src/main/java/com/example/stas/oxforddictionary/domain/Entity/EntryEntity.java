package com.example.stas.oxforddictionary.domain.Entity;



import java.util.ArrayList;
import java.util.List;

public class EntryEntity {


    private List<String> etymologies = null;
    /*@SerializedName("grammaticalFeatures")
    @Expose
    private List<GrammaticalFeature> grammaticalFeatures = null;*/

    private String homographNumber;

    private List<SenseEntity> sense = new ArrayList<>();

    public List<String> getEtymologies() {
        return etymologies;
    }

    public void setEtymologies(List<String> etymologies) {
        this.etymologies = etymologies;
    }

    /*public List<GrammaticalFeature> getGrammaticalFeatures() {
        return grammaticalFeatures;
    }

    public void setGrammaticalFeatures(List<GrammaticalFeature> grammaticalFeatures) {
        this.grammaticalFeatures = grammaticalFeatures;
    }*/

    public String getHomographNumber() {
        return homographNumber;
    }

    public void setHomographNumber(String homographNumber) {
        this.homographNumber = homographNumber;
    }

    public List<SenseEntity> getSense() {
        return sense;
    }

    public void setSens(List<SenseEntity> sens) {
        this.sense = sens;
    }

}
