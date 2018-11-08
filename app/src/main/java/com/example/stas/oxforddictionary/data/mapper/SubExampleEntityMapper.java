package com.example.stas.oxforddictionary.data.mapper;

import com.example.stas.oxforddictionary.data.entity.definition.SubExampleEntity;
import com.example.stas.oxforddictionary.domain.model.definition.SubExample;

import java.util.ArrayList;
import java.util.List;

public class SubExampleEntityMapper {

    public SubExample mapSubexample(SubExampleEntity from){
        SubExample subExample = new SubExample();
        subExample.setText(from.getText());
        return subExample;
    }

    public List<SubExample> mapSubexamples(List<SubExampleEntity> fromList){
        List<SubExample> subexamples = new ArrayList<>();
        for (SubExampleEntity subexample: fromList) {
            subexamples.add(mapSubexample(subexample));
        }
        return subexamples;
    }
}
