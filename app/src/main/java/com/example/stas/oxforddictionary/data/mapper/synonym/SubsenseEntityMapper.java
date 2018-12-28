package com.example.stas.oxforddictionary.data.mapper.synonym;

import com.example.stas.oxforddictionary.data.entity.synonym.SubsenseEntity;
import com.example.stas.oxforddictionary.domain.model.synonym.Subsense;

import java.util.ArrayList;
import java.util.List;

public class SubsenseEntityMapper {

    private SubSynonymEntityMapper subSynonymEntityMapper = new SubSynonymEntityMapper();

    private Subsense mapSubsense(SubsenseEntity from){
        Subsense subsense = new Subsense();
        subsense.setId(from.getId());
        subsense.setRegions(from.getRegions());
        subsense.setRegisters(from.getRegisters());
        subsense.setSynonyms(subSynonymEntityMapper.mapSynonyms(from.getSynonyms()));
        return subsense ;
    }

    List<Subsense> mapSubsenses(List<SubsenseEntity> fromList){
        List<Subsense> subsenses = new ArrayList<>();
        for (SubsenseEntity subsense: fromList) {
            subsenses.add(mapSubsense(subsense));
        }
        return subsenses;
    }
}
