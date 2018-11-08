package com.example.stas.oxforddictionary.data.mapper;

import com.example.stas.oxforddictionary.data.entity.definition.ExampleEntity;
import com.example.stas.oxforddictionary.domain.model.definition.Example;

import java.util.ArrayList;
import java.util.List;

public class ExampleEntityMapper {

    public Example mapExample(ExampleEntity from){
        Example example = new Example();
        example.setText(from.getText());
        return example;
    }

    public List<Example> mapExamples(List<ExampleEntity> fromList){
        List<Example> examples = new ArrayList<>();
        for (ExampleEntity example: fromList) {
            examples.add(mapExample(example));
        }
        return examples;
    }
}
