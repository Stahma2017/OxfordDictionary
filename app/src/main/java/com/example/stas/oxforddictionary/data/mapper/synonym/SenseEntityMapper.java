package com.example.stas.oxforddictionary.data.mapper.synonym;

import com.example.stas.oxforddictionary.data.entity.synonym.SenseEntity;
import com.example.stas.oxforddictionary.domain.model.synonym.Sense;

import java.util.ArrayList;
import java.util.List;

class SenseEntityMapper {

    private ExampleEntityMapper exampleEntityMapper = new ExampleEntityMapper();
    private SubsenseEntityMapper subsenseEntityMapper = new SubsenseEntityMapper();
    private SynonymEntityMapper synonymEntityMapper = new SynonymEntityMapper();

    private Sense mapSense(SenseEntity from){
        return new Sense(
                exampleEntityMapper.mapExamples(from.getExamples()),
                from.getId(),
                subsenseEntityMapper.mapSubsenses(from.getSubsenses()),
                synonymEntityMapper.mapSynonyms(from.getSynonyms())
        );
    }

    List<Sense> mapSenses(List<SenseEntity> fromList){
        List<Sense> senses = new ArrayList<>();
        if(fromList != null){
            for (SenseEntity sense: fromList) {
                senses.add(mapSense(sense));
            }
        }
        return senses;
    }
}
