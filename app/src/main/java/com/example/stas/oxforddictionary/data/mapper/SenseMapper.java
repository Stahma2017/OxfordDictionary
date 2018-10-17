package com.example.stas.oxforddictionary.data.mapper;

import com.example.stas.oxforddictionary.data.model.Sense;
import com.example.stas.oxforddictionary.domain.Entity.SenseEntity;

import java.util.ArrayList;
import java.util.List;

public class SenseMapper {

    private SubsenseMapper subSenseMapper = new SubsenseMapper();

    public SenseEntity mapSense(Sense from){
        SenseEntity senseEntity = new SenseEntity();
        senseEntity.setId(from.getId());
        senseEntity.setDefinitions(from.getDefinitions());
        senseEntity.setShortDefinitions(from.getShortDefinitions());
        senseEntity.setSubsens(subSenseMapper.mapSubsenses(from.getSubsenses()));
        return senseEntity;
    }

    public List<SenseEntity> mapSenses(List<Sense> fromList){
        List<SenseEntity> senses = new ArrayList<>();
        for (Sense sense: fromList) {
            senses.add(mapSense(sense));
        }
        return senses;
    }
}
