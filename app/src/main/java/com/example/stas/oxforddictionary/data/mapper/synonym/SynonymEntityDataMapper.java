package com.example.stas.oxforddictionary.data.mapper.synonym;

import com.example.stas.oxforddictionary.data.entity.synonym.ResultEntity;
import com.example.stas.oxforddictionary.data.entity.synonym.SynonymResponseEntity;
import com.example.stas.oxforddictionary.domain.model.synonym.SynonymResult;

public class SynonymEntityDataMapper {
    private LexicalEntryMapper lexicalEntryMapper = new LexicalEntryMapper();

   public SynonymResult transform(SynonymResponseEntity synonymResponseEntity){
       ResultEntity from = synonymResponseEntity.getResults().get(0);
       return new SynonymResult(
               from.getId(),
               from.getLanguage(),
               lexicalEntryMapper.mapLexicalEntries(from.getLexicalEntries()),
               from.getType(),
               from.getWord()
       );
    }

}
