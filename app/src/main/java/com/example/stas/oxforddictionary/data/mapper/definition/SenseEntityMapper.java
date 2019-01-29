package com.example.stas.oxforddictionary.data.mapper.definition;

import com.example.stas.oxforddictionary.data.entity.definition.SenseEntity;
import com.example.stas.oxforddictionary.domain.model.definition.Sense;

import java.util.ArrayList;
import java.util.List;

class SenseEntityMapper {

    private SubsenseEntityMapper subSenseEntityMapper = new SubsenseEntityMapper();
    private ExampleEntityMapper exampleEntityMapper = new ExampleEntityMapper();

    private Sense mapSense(SenseEntity from){
        return new Sense(
                from.getDefinitions(),
                exampleEntityMapper.mapExamples(from.getExamples()),
                from.getId(),
                from.getShort_definitions(),
                subSenseEntityMapper.mapSubsenses(from.getSubsenses())
        );
    }

    List<Sense> mapSenses(List<SenseEntity> fromList){
        List<Sense> senses = new ArrayList<>();
        if (fromList != null){
            for (SenseEntity senseEntity : fromList) {
                senses.add(mapSense(senseEntity));
            }
        }
        return senses;
    }
}
