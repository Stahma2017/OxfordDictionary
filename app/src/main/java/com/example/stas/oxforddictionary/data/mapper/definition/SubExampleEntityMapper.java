package com.example.stas.oxforddictionary.data.mapper.definition;

import com.example.stas.oxforddictionary.data.entity.definition.SubExampleEntity;
import com.example.stas.oxforddictionary.domain.model.definition.Subexample;

import java.util.ArrayList;
import java.util.List;

class SubExampleEntityMapper {

    private Subexample mapSubexample(SubExampleEntity from){
        return new Subexample(
                from.getText()
        );
    }

    List<Subexample> mapSubexamples(List<SubExampleEntity> fromList){
        List<Subexample> subexamples = new ArrayList<>();
        if(fromList != null){
            for (SubExampleEntity subexample: fromList) {
                subexamples.add(mapSubexample(subexample));
            }
        }
        return subexamples;
    }
}
