package com.example.stas.oxforddictionary.presentation.mapper.definition;

import com.example.stas.oxforddictionary.domain.model.definition.Subsense;
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.SubsenseModel;

import java.util.ArrayList;
import java.util.List;

public class SubsenseModelMapper {

    private SubexampleModelMapper subexampleModelMapper = new SubexampleModelMapper();

    public SubsenseModel mapSubsense(Subsense from){
        return new SubsenseModel(
                from.getDefinitions(),
                subexampleModelMapper.mapSubexamples(from.getExamples()),
                from.getId(),
                from.getShortDefinitions(),
                from.getDomains()
        );
    }

    public List<SubsenseModel> mapSubsenses(List<Subsense> fromList){
        List<SubsenseModel> subsenses = new ArrayList<>();
        if (fromList != null){
            for (Subsense subsense : fromList) {
                subsenses.add(mapSubsense(subsense));
            }
        }
        return subsenses;
    }
}
