package com.example.stas.oxforddictionary.data.mapper.synonym;

import com.example.stas.oxforddictionary.data.entity.synonym.ResultEntity;
import com.example.stas.oxforddictionary.data.entity.synonym.SynonymResponseEntity;
import com.example.stas.oxforddictionary.domain.model.synonym.SynonymResult;

public class SynonymEntityDataMapper {
    private LexicalEntryMapper lexicalEntryMapper = new LexicalEntryMapper();

   public SynonymResult transform(SynonymResponseEntity synonymResponseEntity){
       ResultEntity from = synonymResponseEntity.getResults().get(0);
       SynonymResult result = new SynonymResult();
       result.setId(from.getId());
       result.setLanguage(from.getLanguage());
       result.setType(from.getType());
       result.setWord(from.getWord());
       result.setLexicalEntries(lexicalEntryMapper.mapLexicalEntries(from.getLexicalEntries()));
       return result;
    };

}
