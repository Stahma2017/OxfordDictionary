package com.example.stas.oxforddictionary.presentation.mapper.synonym;

import com.example.stas.oxforddictionary.domain.model.synonym.Subsense;
import com.example.stas.oxforddictionary.presentation.viewmodel.synonym.SubsenseModel;

import java.util.ArrayList;
import java.util.List;

class SubsenseModelMapper {
    private SubsynonymModelMapper subsynonymModelMapper = new SubsynonymModelMapper();

    private SubsenseModel mapSubsense(Subsense from){
        SubsenseModel subsenseModel = new SubsenseModel();
        subsenseModel.setId(from.getId());
        subsenseModel.setRegions(from.getRegions());
        subsenseModel.setRegisters(from.getRegisters());
        subsenseModel.setSynonyms(subsynonymModelMapper.mapSubsynonyms(from.getSynonyms()));
        return subsenseModel;
    }


    List<SubsenseModel> mapSubsenses(List<Subsense> fromList){
        List<SubsenseModel> subsenses = new ArrayList<>();
        for (Subsense subsense: fromList) {
            subsenses.add(mapSubsense(subsense));
        }
        return subsenses;
    }
}
