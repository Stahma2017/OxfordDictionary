package com.example.stas.oxforddictionary.presentation.mapper.definition;

import com.example.stas.oxforddictionary.domain.model.definition.Example;
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.ExampleModel;

import java.util.ArrayList;
import java.util.List;

public class ExampleModelMapper {
    public ExampleModel mapExample(Example from){
        ExampleModel example = new ExampleModel();
        example.setText(from.getText());
        return example;
    }

    public List<ExampleModel> mapExamples(List<Example> fromList){
        List<ExampleModel> examples = new ArrayList<>();
        for (Example example: fromList) {
            examples.add(mapExample(example));
        }
        return examples;
    }
}
