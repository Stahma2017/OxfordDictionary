package com.example.stas.oxforddictionary.data.mapper.definition;

import com.example.stas.oxforddictionary.data.entity.definition.EntryResponseEntity;
import com.example.stas.oxforddictionary.data.entity.definition.ResultEntity;
import com.example.stas.oxforddictionary.domain.model.definition.DefinitionResult;


public class DefinitionEntityDataMapper {

    private LexicalEntryEntityMapper lexicalEntryEntityMapper = new LexicalEntryEntityMapper();

    public DefinitionResult transform(EntryResponseEntity entryResponseEntity){
        ResultEntity from = entryResponseEntity.getResults().get(0);
        return new DefinitionResult(
                from.getId(),
                from.getLanguage(),
                lexicalEntryEntityMapper.mapLexicalEntries(from.getLexicalEntries()),
                from.getType(),
                from.getWord()
        );
    }
}
