package com.example.stas.oxforddictionary.data.mapper.example;

import com.example.stas.oxforddictionary.data.entity.example.LexicalEntryEntity;
import com.example.stas.oxforddictionary.domain.model.example.LexicalEntry;

import java.util.ArrayList;
import java.util.List;

class LexicalEntryEntityMapper {

    private SentenceEntityMapper sentenceEntityMapper = new SentenceEntityMapper();

    private LexicalEntry mapLexicalEntry(LexicalEntryEntity from){
        LexicalEntry lexicalEntry = new LexicalEntry();
        lexicalEntry.setLanguage(from.getLanguage());
        lexicalEntry.setLexicalCategory(from.getLexicalCategory());
        lexicalEntry.setText(from.getText());
        lexicalEntry.setSentences(sentenceEntityMapper.mapSentences(from.getSentences()));
        return lexicalEntry;
    }

   List<LexicalEntry> mapLexicalEntries(List<LexicalEntryEntity> fromList){
       List<LexicalEntry> lexicalEntries = new ArrayList<>();
       for (LexicalEntryEntity lexicalEntry: fromList) {
           lexicalEntries.add(mapLexicalEntry(lexicalEntry));
       }
       return lexicalEntries;
    }
}
