package com.example.stas.oxforddictionary.presentation.mapper.synonym;

import com.example.stas.oxforddictionary.domain.model.synonym.Sense;
import com.example.stas.oxforddictionary.presentation.viewmodel.synonym.SenseModel;

import java.util.ArrayList;
import java.util.List;

class SenseModelMapper {
    private ExampleModelMapper exampleModelMapper = new ExampleModelMapper();
    private SynonymModelMapper synonymModelMapper = new SynonymModelMapper();
    private SubsenseModelMapper subsenseModelMapper = new SubsenseModelMapper();

    private SenseModel mapSense(Sense from){
        return new SenseModel(
                exampleModelMapper.mapExamples(from.getExamples()),
                from.getId(),
                subsenseModelMapper.mapSubsenses(from.getSubsenses()),
                synonymModelMapper.mapSynonyms(from.getSynonyms())
        );
    }

    List<SenseModel> mapSenses(List<Sense> fromList){
        List<SenseModel> senses = new ArrayList<>();
        for (Sense sense: fromList) {
            senses.add(mapSense(sense));
        }
        return senses;
    }
}
