package com.example.stas.oxforddictionary.data.mapper.definition;

import com.example.stas.oxforddictionary.data.entity.definition.LexicalEntryEntity;
import com.example.stas.oxforddictionary.domain.model.definition.LexicalEntry;

import java.util.ArrayList;
import java.util.List;

class LexicalEntryEntityMapper {
    private EntryEntityMapper entryEntityMapper = new EntryEntityMapper();
    private PronunciationEntityMapper pronunciationEntityMapper = new PronunciationEntityMapper();

    private LexicalEntry mapLexicalEntry(LexicalEntryEntity from){
        LexicalEntry lexicalEntry = new LexicalEntry();
        lexicalEntry.setLanguage(from.getLanguage());
        lexicalEntry.setText(from.getText());
        lexicalEntry.setLexicalCategory(from.getLexicalCategory());
        lexicalEntry.setEntries(entryEntityMapper.mapEntries(from.getEntries()));
        lexicalEntry.setPronunciationEntities(pronunciationEntityMapper.mapPronunciations(from.getPronunciations()));
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
