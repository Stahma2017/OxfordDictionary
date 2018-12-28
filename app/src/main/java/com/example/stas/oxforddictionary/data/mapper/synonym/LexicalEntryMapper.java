package com.example.stas.oxforddictionary.data.mapper.synonym;

import com.example.stas.oxforddictionary.data.entity.synonym.LexicalEntryEntity;
import com.example.stas.oxforddictionary.domain.model.synonym.LexicalEntry;

import java.util.ArrayList;
import java.util.List;

class LexicalEntryMapper {

    EntryEntityMapper entryEntityMapper = new EntryEntityMapper();


    private LexicalEntry mapLexicalEntry(LexicalEntryEntity from){
        LexicalEntry lexicalEntry = new LexicalEntry();
        lexicalEntry.setLanguage(from.getLanguage());
        lexicalEntry.setLexicalCategory(from.getLexicalCategory());
        lexicalEntry.setText(from.getText());
        lexicalEntry.setEntries(entryEntityMapper.mapEntries(from.getEntries()));
        return lexicalEntry;
    }

    List<LexicalEntry> mapLexicalEntries(List<LexicalEntryEntity> fromList){
        List<LexicalEntry> entries = new ArrayList<>();
        for (LexicalEntryEntity lexicalEntry: fromList) {
            entries.add(mapLexicalEntry(lexicalEntry));
        }
        return entries;
    }




}
