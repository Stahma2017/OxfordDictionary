package com.example.stas.oxforddictionary.data.mapper.definition;

import com.example.stas.oxforddictionary.data.entity.definition.SubExampleEntity;
import com.example.stas.oxforddictionary.domain.model.definition.SubExample;

import java.util.ArrayList;
import java.util.List;

class SubExampleEntityMapper {

    private SubExample mapSubexample(SubExampleEntity from){
        SubExample subExample = new SubExample();
        subExample.setText(from.getText());
        return subExample;
    }

    List<SubExample> mapSubexamples(List<SubExampleEntity> fromList){
        List<SubExample> subexamples = new ArrayList<>();
        for (SubExampleEntity subexample: fromList) {
            subexamples.add(mapSubexample(subexample));
        }
        return subexamples;
    }
}
