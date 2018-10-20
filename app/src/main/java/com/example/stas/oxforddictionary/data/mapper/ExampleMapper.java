package com.example.stas.oxforddictionary.data.mapper;

import com.example.stas.oxforddictionary.data.model.Example;
import com.example.stas.oxforddictionary.domain.Entity.ExampleEntity;

import java.util.ArrayList;
import java.util.List;

public class ExampleMapper {

    public ExampleEntity mapExample(Example from){
        ExampleEntity exampleEntity = new ExampleEntity();
        exampleEntity.setText(from.getText());
        return exampleEntity;
    }

    public List<ExampleEntity> mapExamples(List<Example> fromList){
        List<ExampleEntity> examples = new ArrayList<>();
        for (Example example: fromList) {
            examples.add(mapExample(example));
        }
        return examples;
    }
}
