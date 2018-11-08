package com.example.stas.oxforddictionary.data.mapper;

import com.example.stas.oxforddictionary.data.entity.definition.SenseEntity;
import com.example.stas.oxforddictionary.domain.model.definition.Sense;

import java.util.ArrayList;
import java.util.List;

public class SenseEntityMapper {

    private SubsenseEntityMapper subSenseEntityMapper = new SubsenseEntityMapper();
    private ExampleEntityMapper exampleEntityMapper = new ExampleEntityMapper();

    public Sense mapSense(SenseEntity from){
        Sense sense = new Sense();
        sense.setId(from.getId());
        sense.setDefinitions(from.getDefinitions());
        sense.setShortDefinitions(from.getShortDefinitions());
        sense.setSubsens(subSenseEntityMapper.mapSubsenses(from.getSubsenses()));
        sense.setExamples(exampleEntityMapper.mapExamples(from.getExamples()));
        return sense;
    }

    public List<Sense> mapSenses(List<SenseEntity> fromList){
        List<Sense> senses = new ArrayList<>();
        for (SenseEntity senseEntity : fromList) {
            senses.add(mapSense(senseEntity));
        }
        return senses;
    }
}
