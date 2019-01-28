package com.example.stas.oxforddictionary.data.mapper.definition;

import com.example.stas.oxforddictionary.data.entity.definition.EntryResponseEntity;
import com.example.stas.oxforddictionary.data.entity.definition.ResultEntity;
import com.example.stas.oxforddictionary.domain.model.definition.DefinitionResult;


public class DefinitionEntityDataMapper {

    private LexicalEntryEntityMapper lexicalEntryEntityMapper = new LexicalEntryEntityMapper();

    public DefinitionResult transform(EntryResponseEntity entryResponseEntity){
        ResultEntity from = entryResponseEntity.getResults().get(0);
        DefinitionResult result = new DefinitionResult();
        result.setId(from.getId());
        result.setLanguage(from.getLanguage());
        result.setType(from.getType());
        result.setWord(from.getWord());
        result.setLexicalEntries(lexicalEntryEntityMapper.mapLexicalEntries(from.getLexicalEntries()));
        return result;
    }




}
