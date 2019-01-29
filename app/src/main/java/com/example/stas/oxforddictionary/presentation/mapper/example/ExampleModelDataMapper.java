package com.example.stas.oxforddictionary.presentation.mapper.example;

import com.example.stas.oxforddictionary.domain.model.example.ExampleResult;
import com.example.stas.oxforddictionary.presentation.viewmodel.example.ExampleResultModel;

public class ExampleModelDataMapper {

    private LexicalEntryModelMapper lexicalEntryModelMapper = new LexicalEntryModelMapper();

    public ExampleResultModel transform(ExampleResult from){
        return new ExampleResultModel(
                from.getId(),
                from.getLanguage(),
                lexicalEntryModelMapper.mapLexicalEntries(from.getLexicalEntries()),
                from.getType(),
                from.getWord()
        );
    }
}
