package com.example.stas.oxforddictionary.data.mapper.example;

import com.example.stas.oxforddictionary.data.entity.example.ExampleResponseEntity;
import com.example.stas.oxforddictionary.data.entity.example.ExampleResultEntity;
import com.example.stas.oxforddictionary.domain.model.example.ExampleResult;

public class ExampleEntityDataMapper {

    private LexicalEntryEntityMapper lexicalEntryEntityMapper = new LexicalEntryEntityMapper();

    public ExampleResult transform(ExampleResponseEntity exampleResponseEntity){
        ExampleResultEntity from = exampleResponseEntity.getResults().get(0);
        ExampleResult result = new ExampleResult();
        result.setId(from.getId());
        result.setLanguage(from.getLanguage());
        result.setType(from.getType());
        result.setWord(from.getWord());
        result.setLexicalEntries(lexicalEntryEntityMapper.mapLexicalEntries(from.getLexicalEntries()));
        return result;
    }
}
