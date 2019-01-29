package com.example.stas.oxforddictionary.presentation.mapper.definition;

import com.example.stas.oxforddictionary.domain.model.definition.Subexample;
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.SubexampleModel;

import java.util.ArrayList;
import java.util.List;

class SubexampleModelMapper {
    private SubexampleModel mapSubexample(Subexample from){
        return new SubexampleModel(
                from.getText()
        );
    }

    List<SubexampleModel> mapSubexamples(List<Subexample> fromList){
        List<SubexampleModel> subexamples = new ArrayList<>();
        if (fromList != null){
            for (Subexample subexample: fromList) {
                subexamples.add(mapSubexample(subexample));
            }
        }
        return subexamples;
    }
}
