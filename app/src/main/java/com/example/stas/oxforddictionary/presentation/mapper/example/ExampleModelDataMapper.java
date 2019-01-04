package com.example.stas.oxforddictionary.presentation.mapper.example;

import com.example.stas.oxforddictionary.domain.model.example.ExampleResult;
import com.example.stas.oxforddictionary.presentation.viewmodel.example.ExampleResultModel;

public class ExampleModelDataMapper {

    private LexicalEntryModelMapper lexicalEntryModelMapper = new LexicalEntryModelMapper();

    public ExampleResultModel transform(ExampleResult from){
        ExampleResultModel resultModel = new ExampleResultModel();
        resultModel.setId(from.getId());
        resultModel.setLanguage(from.getLanguage());
        resultModel.setType(from.getType());
        resultModel.setWord(from.getWord());
        resultModel.setLexicalEntries(lexicalEntryModelMapper.mapLexicalEntries(from.getLexicalEntries()));
        return resultModel;
    }
}
