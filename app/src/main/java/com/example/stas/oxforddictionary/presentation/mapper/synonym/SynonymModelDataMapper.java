package com.example.stas.oxforddictionary.presentation.mapper.synonym;

import com.example.stas.oxforddictionary.domain.model.synonym.Result;
import com.example.stas.oxforddictionary.presentation.viewmodel.synonym.ResultModel;

public class SynonymModelDataMapper {

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
