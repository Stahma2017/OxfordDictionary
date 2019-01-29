package com.example.stas.oxforddictionary.data.mapper.synonym;

import com.example.stas.oxforddictionary.data.entity.synonym.SubsenseEntity;
import com.example.stas.oxforddictionary.domain.model.synonym.Subsense;

import java.util.ArrayList;
import java.util.List;

class SubsenseEntityMapper {

    private SubSynonymEntityMapper subSynonymEntityMapper = new SubSynonymEntityMapper();

    private Subsense mapSubsense(SubsenseEntity from){
        return new Subsense(
                from.getId(),
                subSynonymEntityMapper.mapSynonyms(from.getSynonyms()),
                from.getRegisters(),
                from.getRegions()
        );
    }

    List<Subsense> mapSubsenses(List<SubsenseEntity> fromList){
        List<Subsense> subsenses = new ArrayList<>();
        if (fromList != null) {
            for (SubsenseEntity subsense: fromList) {
                subsenses.add(mapSubsense(subsense));
            }
        }
        return subsenses;
    }
}
