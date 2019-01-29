package com.example.stas.oxforddictionary.data.mapper.definition;

import com.example.stas.oxforddictionary.data.entity.definition.SubsenseEntity;
import com.example.stas.oxforddictionary.domain.model.definition.Subsense;


import java.util.ArrayList;
import java.util.List;

class SubsenseEntityMapper {

    private SubExampleEntityMapper subExampleEntityMapper = new SubExampleEntityMapper();

    private Subsense mapSubsense(SubsenseEntity from){
        return new Subsense(
                from.getId(),
                from.getDomains(),
                from.getDefinitions(),
                from.getShort_definitions(),
                subExampleEntityMapper.mapSubexamples(from.getExamples())
        );
    }

    List<Subsense> mapSubsenses(List<SubsenseEntity> fromList){
        List<Subsense> subsenses = new ArrayList<>();
        if (fromList != null){
            for (SubsenseEntity subsenseEntity : fromList) {
                subsenses.add(mapSubsense(subsenseEntity));
            }
        }
        return subsenses;
    }
}
