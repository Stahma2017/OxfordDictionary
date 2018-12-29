package com.example.stas.oxforddictionary.presentation.mapper.definition;

import com.example.stas.oxforddictionary.domain.model.definition.Result;
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.ResultModel;

public class DefinitionModelDataMapper {


    private LexicalEntryModelMapper lexicalEntryModelMapper = new LexicalEntryModelMapper();

    public ResultModel transform(Result from){
        ResultModel resultModel = new ResultModel();
        resultModel.setId(from.getId());
        resultModel.setLanguage(from.getLanguage());
        resultModel.setType(from.getType());
        resultModel.setWord(from.getWord());
        resultModel.setLexicalEntries(lexicalEntryModelMapper.mapLexicalEntries(from.getLexicalEntries()));
        return resultModel;
    }
}
