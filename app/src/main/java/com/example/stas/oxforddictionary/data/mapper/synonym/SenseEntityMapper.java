package com.example.stas.oxforddictionary.data.mapper.synonym;

import com.example.stas.oxforddictionary.data.entity.synonym.SenseEntity;
import com.example.stas.oxforddictionary.domain.model.synonym.Sense;

import java.util.ArrayList;
import java.util.List;

public class SenseEntityMapper {

    private ExampleEntityMapper exampleEntityMapper = new ExampleEntityMapper();
    private SubsenseEntityMapper subsenseEntityMapper = new SubsenseEntityMapper();
    private SynonymEntityMapper synonymEntityMapper = new SynonymEntityMapper();

    private Sense mapSense(SenseEntity from){
        Sense sense = new Sense();
        sense.setId(from.getId());
        sense.setExamples(exampleEntityMapper.mapExamples(from.getExamples()));
        sense.setSubsenses(subsenseEntityMapper.mapSubsenses(from.getSubsenses()));
        sense.setSynonyms(synonymEntityMapper.mapSynonyms(from.getSynonyms()));
        return sense;
    }
    List<Sense> mapSenses(List<SenseEntity> fromList){
        List<Sense> senses = new ArrayList<>();
        for (SenseEntity sense: fromList) {
            senses.add(mapSense(sense));
        }
        return senses;
    }
}
