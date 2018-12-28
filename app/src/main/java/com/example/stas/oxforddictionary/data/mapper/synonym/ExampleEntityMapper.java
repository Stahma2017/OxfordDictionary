package com.example.stas.oxforddictionary.data.mapper.synonym;

import com.example.stas.oxforddictionary.data.entity.synonym.ExampleEntity;
import com.example.stas.oxforddictionary.domain.model.synonym.Example;

import java.util.ArrayList;
import java.util.List;

public class ExampleEntityMapper {

    private Example mapExample(ExampleEntity from){
        Example example = new Example();
        example.setText(from.getText());
        return example;
    }

    List<Example> mapExamples(List<ExampleEntity> fromList){
        List<Example> examples = new ArrayList<>();
        for (ExampleEntity example:fromList) {
            examples.add(mapExample(example));
        }
        return examples;
    }

}
