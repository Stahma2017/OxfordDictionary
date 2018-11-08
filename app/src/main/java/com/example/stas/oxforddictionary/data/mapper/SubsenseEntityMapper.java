package com.example.stas.oxforddictionary.data.mapper;

import com.example.stas.oxforddictionary.data.entity.definition.SubsenseEntity;
import com.example.stas.oxforddictionary.domain.model.definition.Subsense;

import java.util.ArrayList;
import java.util.List;

public class SubsenseEntityMapper {

    private SubExampleEntityMapper subExampleEntityMapper = new SubExampleEntityMapper();


    public Subsense mapSubsense(SubsenseEntity from){
        Subsense subsense = new Subsense();
        subsense.setDefinitions(from.getDefinitions());
        subsense.setDomains(from.getDomains());
        subsense.setId(from.getId());
        subsense.setShortDefinitions(from.getShortDefinitions());
        subsense.setExamples(subExampleEntityMapper.mapSubexamples(from.getExamples()));
        return subsense;
    }

    public List<Subsense> mapSubsenses(List<SubsenseEntity> fromList){
        List<Subsense> subsenses = new ArrayList<>();
        for (SubsenseEntity subsenseEntity : fromList) {
            subsenses.add(mapSubsense(subsenseEntity));
        }
        return subsenses;
    }
}
