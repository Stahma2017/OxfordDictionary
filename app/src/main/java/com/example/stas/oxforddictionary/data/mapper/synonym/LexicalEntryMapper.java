package com.example.stas.oxforddictionary.data.mapper.synonym;


import com.example.stas.oxforddictionary.data.entity.synonym.LexicalEntryEntity;
import com.example.stas.oxforddictionary.domain.model.synonym.LexicalEntry;

import java.util.ArrayList;
import java.util.List;

class LexicalEntryMapper {

    EntryEntityMapper entryEntityMapper = new EntryEntityMapper();


    private LexicalEntry mapLexicalEntry(LexicalEntryEntity from){
        return new LexicalEntry(
                entryEntityMapper.mapEntries(from.getEntries()),
                from.getLanguage(),
                from.getLexicalCategory(),
                from.getText()
        );
    }

    List<LexicalEntry> mapLexicalEntries(List<LexicalEntryEntity> fromList){
        List<LexicalEntry> entries = new ArrayList<>();
        if(fromList != null){
            for (LexicalEntryEntity lexicalEntry: fromList) {
                entries.add(mapLexicalEntry(lexicalEntry));
            }
        }
        return entries;
    }




}
