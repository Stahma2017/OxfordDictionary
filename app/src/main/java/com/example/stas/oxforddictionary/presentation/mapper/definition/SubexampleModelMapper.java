package com.example.stas.oxforddictionary.presentation.mapper.definition;

import com.example.stas.oxforddictionary.domain.model.definition.SubExample;
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.SubexampleModel;

import java.util.ArrayList;
import java.util.List;

public class SubexampleModelMapper {
    public SubexampleModel mapSubexample(SubExample from){
        SubexampleModel subexample = new SubexampleModel();
        subexample.setText(from.getText());
        return subexample;
    }

    public List<SubexampleModel> mapSubexamples(List<SubExample> fromList){
        List<SubexampleModel> subexamples = new ArrayList<>();
        for (SubExample subexample: fromList) {
            subexamples.add(mapSubexample(subexample));
        }
        return subexamples;
    }
}
