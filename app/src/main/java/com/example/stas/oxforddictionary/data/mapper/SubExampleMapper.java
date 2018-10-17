package com.example.stas.oxforddictionary.data.mapper;

import com.example.stas.oxforddictionary.data.model.SubExample;
import com.example.stas.oxforddictionary.domain.Entity.SubExampleEntity;

import java.util.ArrayList;
import java.util.List;

public class SubExampleMapper {

    public SubExampleEntity mapSubexample(SubExample from){
        SubExampleEntity subExampleEntity = new SubExampleEntity();
        subExampleEntity.setText(from.getText());
        return subExampleEntity;
    }

    public List<SubExampleEntity> mapSubexamples(List<SubExample> fromList){
        List<SubExampleEntity> subexamples = new ArrayList<>();
        for (SubExample subexample: fromList) {
            subexamples.add(mapSubexample(subexample));
        }
        return subexamples;
    }
}
