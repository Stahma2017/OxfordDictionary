package com.example.stas.oxforddictionary.data.mapper;

import com.example.stas.oxforddictionary.data.model.LexicalEntry;
import com.example.stas.oxforddictionary.domain.Entity.LexicalEntryEntity;


public class LexicalEntryMapper {

    private EntryMapper entryMapper = new EntryMapper();
    private PronunciationMapper pronunciationMapper = new PronunciationMapper();

    public LexicalEntryMapper(EntryMapper entryMapper, PronunciationMapper pronunciationMapper) {
        this.entryMapper = entryMapper;
        this.pronunciationMapper = pronunciationMapper;
    }

    public LexicalEntryEntity mapLexicalEntry(LexicalEntry from){
        LexicalEntryEntity lexicalEntryEntity = new LexicalEntryEntity();
        lexicalEntryEntity.setLanguage(from.getLanguage());
        lexicalEntryEntity.setLexicalCategory(from.getLexicalCategory());
        lexicalEntryEntity.setText(from.getText());
        lexicalEntryEntity.setEntries(entryMapper.mapEntries(from.getEntries()));
        lexicalEntryEntity.setPronunciationEntities(pronunciationMapper.mapPronunciations(from.getPronunciations()));
        return lexicalEntryEntity;
    }
}
