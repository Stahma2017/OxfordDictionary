package com.example.stas.oxforddictionary.data.mapper.definition;

import com.example.stas.oxforddictionary.data.entity.definition.EntryResponseEntity;
import com.example.stas.oxforddictionary.data.entity.definition.LexicalEntryEntity;
import com.example.stas.oxforddictionary.data.entity.definition.ResultEntity;
import com.example.stas.oxforddictionary.domain.model.definition.LexicalEntry;
import com.example.stas.oxforddictionary.domain.model.definition.Result;


public class DefinitionEntityDataMapper {

    private LexicalEntryEntityMapper lexicalEntryEntityMapper = new LexicalEntryEntityMapper();

    public Result transform(EntryResponseEntity entryResponseEntity){
        ResultEntity from = entryResponseEntity.getResultEntities().get(0);
        Result result = new Result();
        result.setId(from.getId());
        result.setLanguage(from.getLanguage());
        result.setType(from.getType());
        result.setWord(from.getWord());
        result.setLexicalEntries(lexicalEntryEntityMapper.mapLexicalEntries(from.getLexicalEntries()));
        return result;
    }




}
