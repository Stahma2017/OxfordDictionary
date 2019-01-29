package com.example.stas.oxforddictionary.presentation.mapper.definition;

import com.example.stas.oxforddictionary.domain.model.definition.DefinitionResult;
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.ResultModel;

public class DefinitionModelDataMapper {

    private LexicalEntryModelMapper lexicalEntryModelMapper = new LexicalEntryModelMapper();

    public ResultModel transform(DefinitionResult from){
        return new ResultModel(
                from.getId(),
                from.getLanguage(),
                lexicalEntryModelMapper.mapLexicalEntries(from.getLexicalEntries()),
                from.getType(),
                from.getWord()
        );
    }
}
