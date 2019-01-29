package com.example.stas.oxforddictionary.presentation.mapper.synonym;

import com.example.stas.oxforddictionary.domain.model.synonym.SynonymResult;
import com.example.stas.oxforddictionary.presentation.viewmodel.synonym.ResultModel;

public class SynonymModelDataMapper {

    private LexicalEntryModelMapper lexicalEntryModelMapper = new LexicalEntryModelMapper();

    public ResultModel transform(SynonymResult from){
        return new ResultModel(
                from.getId(),
                from.getLanguage(),
                lexicalEntryModelMapper.mapLexicalEntries(from.getLexicalEntries()),
                from.getType(),
                from.getWord()
        );
    }
}
