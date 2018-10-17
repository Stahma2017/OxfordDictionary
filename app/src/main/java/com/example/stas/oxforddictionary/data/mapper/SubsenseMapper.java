package com.example.stas.oxforddictionary.data.mapper;

import com.example.stas.oxforddictionary.data.model.Subsense;
import com.example.stas.oxforddictionary.domain.Entity.SubsenseEntity;

import java.util.ArrayList;
import java.util.List;

public class SubsenseMapper {

    private SubExampleMapper subExampleMapper = new SubExampleMapper();


    public SubsenseEntity mapSubsense(Subsense from){
        SubsenseEntity subsenseEntity = new SubsenseEntity();
        subsenseEntity.setDefinitions(from.getDefinitions());
        subsenseEntity.setDomains(from.getDomains());
        subsenseEntity.setId(from.getId());
        subsenseEntity.setShortDefinitions(from.getShortDefinitions());
        subsenseEntity.setExamples(subExampleMapper.mapSubexamples(from.getExamples()));
        return subsenseEntity;
    }

    public List<SubsenseEntity> mapSubsenses(List<Subsense> fromList){
        List<SubsenseEntity> subsenses = new ArrayList<>();
        for (Subsense subsense: fromList) {
            subsenses.add(mapSubsense(subsense));
        }
        return subsenses;
    }
}
