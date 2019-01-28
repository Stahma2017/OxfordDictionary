package com.example.stas.oxforddictionary.data.mapper.example;

import com.example.stas.oxforddictionary.data.entity.example.ExampleResponseEntity;
import com.example.stas.oxforddictionary.data.entity.example.ExampleResultEntity;
import com.example.stas.oxforddictionary.domain.model.example.ExampleResult;

public class ExampleEntityDataMapper {

    private LexicalEntryEntityMapper lexicalEntryEntityMapper = new LexicalEntryEntityMapper();

    public ExampleResult transform(ExampleResponseEntity exampleResponseEntity){
        ExampleResultEntity from = exampleResponseEntity.getResults().get(0);
        return new ExampleResult(from.getId(),
                from.getLanguage(),
                lexicalEntryEntityMapper.mapLexicalEntries(from.getLexicalEntries()),
                from.getType(),
                from.getWord());
    }
}
