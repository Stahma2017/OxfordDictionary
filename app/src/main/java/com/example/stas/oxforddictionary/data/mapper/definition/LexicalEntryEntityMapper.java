package com.example.stas.oxforddictionary.data.mapper.definition;

import com.example.stas.oxforddictionary.data.entity.definition.LexicalEntryEntity;
import com.example.stas.oxforddictionary.domain.model.definition.LexicalEntry;

import java.util.ArrayList;
import java.util.List;

class LexicalEntryEntityMapper {
    private EntryEntityMapper entryEntityMapper = new EntryEntityMapper();
    private PronunciationEntityMapper pronunciationEntityMapper = new PronunciationEntityMapper();

    private LexicalEntry mapLexicalEntry(LexicalEntryEntity from){
        return new LexicalEntry(
                entryEntityMapper.mapEntries(from.getEntries()),
                from.getLanguage(),
                from.getLexicalCategory(),
                pronunciationEntityMapper.mapPronunciations(from.getPronunciations()),
                from.getText()
        );
    }

    List<LexicalEntry> mapLexicalEntries(List<LexicalEntryEntity> fromList){
        List<LexicalEntry> lexicalEntries = new ArrayList<>();
        if (fromList != null){
            for (LexicalEntryEntity lexicalEntry: fromList) {
                lexicalEntries.add(mapLexicalEntry(lexicalEntry));
            }
        }
        return lexicalEntries;
    }
}
