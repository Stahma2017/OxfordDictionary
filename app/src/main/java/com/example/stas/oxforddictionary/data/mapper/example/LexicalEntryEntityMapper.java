package com.example.stas.oxforddictionary.data.mapper.example;

import com.example.stas.oxforddictionary.data.entity.example.LexicalEntryEntity;
import com.example.stas.oxforddictionary.domain.model.example.LexicalEntry;

import java.util.ArrayList;
import java.util.List;

class LexicalEntryEntityMapper {

    private SentenceEntityMapper sentenceEntityMapper = new SentenceEntityMapper();

    private LexicalEntry mapLexicalEntry(LexicalEntryEntity from){
        return new LexicalEntry(
                from.getLanguage(),
                from.getLexicalCategory(),
                sentenceEntityMapper.mapSentences(from.getSentences()),
                from.getText()
        );
    }

   List<LexicalEntry> mapLexicalEntries(List<LexicalEntryEntity> fromList){
       List<LexicalEntry> lexicalEntries = new ArrayList<>();
       if(fromList != null){
           for (LexicalEntryEntity lexicalEntry: fromList) {
               lexicalEntries.add(mapLexicalEntry(lexicalEntry));
           }
       }
       return lexicalEntries;
    }
}
