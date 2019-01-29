package com.example.stas.oxforddictionary.presentation.mapper.definition;

import com.example.stas.oxforddictionary.domain.model.definition.Example;
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.ExampleModel;

import java.util.ArrayList;
import java.util.List;

class ExampleModelMapper {
    private ExampleModel mapExample(Example from){
        return new ExampleModel(
                from.getText()
        );
    }

    List<ExampleModel> mapExamples(List<Example> fromList){
        List<ExampleModel> examples = new ArrayList<>();
        if (fromList != null){
            for (Example example: fromList) {
                examples.add(mapExample(example));
            }
        }
        return examples;
    }
}
