package com.example.stas.oxforddictionary.data.mapper.definition;

import com.example.stas.oxforddictionary.data.entity.definition.ExampleEntity;
import com.example.stas.oxforddictionary.domain.model.definition.Example;

import java.util.ArrayList;
import java.util.List;

class ExampleEntityMapper {

    private Example mapExample(ExampleEntity from) {
        return new Example(
                from.getText()
        );
    }

    List<Example> mapExamples(List<ExampleEntity> fromList){
        List<Example> examples = new ArrayList<>();
        if (fromList != null){
            for (ExampleEntity example: fromList) {
                examples.add(mapExample(example));
            }
        }
        return examples;
    }
}
