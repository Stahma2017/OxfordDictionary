package com.example.stas.oxforddictionary.presentation.mapper.definition;

import com.example.stas.oxforddictionary.domain.model.definition.Sense;
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.SenseModel;

import java.util.ArrayList;
import java.util.List;

public class SenseModelMapper {
    private SubsenseModelMapper subSenseModelMapper = new SubsenseModelMapper();
    private ExampleModelMapper exampleModelMapper = new ExampleModelMapper();

    public SenseModel mapSense(Sense from){
        return new SenseModel(
                from.getDefinitions(),
                exampleModelMapper.mapExamples(from.getExamples()),
                from.getId(),
                from.getShortDefinitions(),
                subSenseModelMapper.mapSubsenses(from.getSubsenses())
        );
    }

    public List<SenseModel> mapSenses(List<Sense> fromList){
        List<SenseModel> senses = new ArrayList<>();
        if (fromList != null){
            for (Sense sense : fromList) {
                senses.add(mapSense(sense));
            }
        }
        return senses;
    }
}
