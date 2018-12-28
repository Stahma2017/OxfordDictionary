package com.example.stas.oxforddictionary.presentation.mapper.definition;

import com.example.stas.oxforddictionary.domain.model.definition.Subsense;
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.SubsenseModel;

import java.util.ArrayList;
import java.util.List;

public class SubsenseModelMapper {

    private SubexampleModelMapper subexampleModelMapper = new SubexampleModelMapper();

    public SubsenseModel mapSubsense(Subsense from){
        SubsenseModel subsense = new SubsenseModel();
        subsense.setDefinitions(from.getDefinitions());
        subsense.setDomains(from.getDomains());
        subsense.setId(from.getId());
        subsense.setShortDefinitions(from.getShortDefinitions());
        subsense.setExamples(subexampleModelMapper.mapSubexamples(from.getExamples()));
        return subsense;
    }

    public List<SubsenseModel> mapSubsenses(List<Subsense> fromList){
        List<SubsenseModel> subsenses = new ArrayList<>();
        for (Subsense subsense : fromList) {
            subsenses.add(mapSubsense(subsense));
        }
        return subsenses;
    }
}
