package com.example.stas.oxforddictionary.presentation.mapper.definition;

import com.example.stas.oxforddictionary.domain.model.definition.Sense;
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.SenseModel;

import java.util.ArrayList;
import java.util.List;

public class SenseModelMapper {
    private SubsenseModelMapper subSenseModelMapper = new SubsenseModelMapper();
    private ExampleModelMapper exampleModelMapper = new ExampleModelMapper();

    public SenseModel mapSense(Sense from){
        SenseModel sense = new SenseModel();
        sense.setId(from.getId());
        sense.setDefinitions(from.getDefinitions());
        sense.setShortDefinitions(from.getShortDefinitions());
        sense.setSubsens(subSenseModelMapper.mapSubsenses(from.getSubsens()));
        sense.setExamples(exampleModelMapper.mapExamples(from.getExamples()));
        return sense;
    }

    public List<SenseModel> mapSenses(List<Sense> fromList){
        List<SenseModel> senses = new ArrayList<>();
        for (Sense sense : fromList) {
            senses.add(mapSense(sense));
        }
        return senses;
    }
}
