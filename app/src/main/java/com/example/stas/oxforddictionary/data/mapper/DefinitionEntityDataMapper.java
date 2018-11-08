package com.example.stas.oxforddictionary.data.mapper;

import com.example.stas.oxforddictionary.data.entity.definition.EntryResponseEntity;
import com.example.stas.oxforddictionary.data.entity.definition.LexicalEntryEntity;
import com.example.stas.oxforddictionary.domain.model.definition.LexicalEntry;


public class DefinitionEntityDataMapper {

    private EntryEntityMapper entryEntityMapper = new EntryEntityMapper();
    private PronunciationEntityMapper pronunciationEntityMapper = new PronunciationEntityMapper();

    public LexicalEntry transform(EntryResponseEntity entryResponseEntity){
        LexicalEntryEntity from = entryResponseEntity.getResultEntities().get(0).getLexicalEntries().get(0);
        LexicalEntry lexicalEntry = new LexicalEntry();
        lexicalEntry.setLanguage(from.getLanguage());
        lexicalEntry.setLexicalCategory(from.getLexicalCategory());
        lexicalEntry.setText(from.getText());
        lexicalEntry.setEntries(entryEntityMapper.mapEntries(from.getEntries()));
        lexicalEntry.setPronunciationEntities(pronunciationEntityMapper.mapPronunciations(from.getPronunciationEntities()));
        return lexicalEntry;
    }
}
