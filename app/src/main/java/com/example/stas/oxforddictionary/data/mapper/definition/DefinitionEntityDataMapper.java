package com.example.stas.oxforddictionary.data.mapper.definition;

import com.example.stas.oxforddictionary.data.entity.definition.EntryResponseEntity;
import com.example.stas.oxforddictionary.data.entity.definition.LexicalEntryEntity;
import com.example.stas.oxforddictionary.data.entity.definition.ResultEntity;
import com.example.stas.oxforddictionary.domain.model.definition.LexicalEntry;
import com.example.stas.oxforddictionary.domain.model.definition.Result;


public class DefinitionEntityDataMapper {

    private EntryEntityMapper entryEntityMapper = new EntryEntityMapper();
    private PronunciationEntityMapper pronunciationEntityMapper = new PronunciationEntityMapper();

    public LexicalEntry transform(EntryResponseEntity entryResponseEntity){
        ResultEntity from = entryResponseEntity.getResultEntities().get(0);

       // LexicalEntryEntity from = entryResponseEntity.getResultEntities().get(0).getLexicalEntries().get(0);
        Result result = new Result();

        LexicalEntry lexicalEntry = new LexicalEntry();
        lexicalEntry.setLanguage(from.getLanguage());
        lexicalEntry.setLexicalCategory(from.getLexicalCategory());
        lexicalEntry.setText(from.getText());
        lexicalEntry.setEntries(entryEntityMapper.mapEntries(from.getEntries()));
        lexicalEntry.setPronunciationEntities(pronunciationEntityMapper.mapPronunciations(from.getPronunciationEntities()));
        return lexicalEntry;
    }



/*
    private EntryEntityMapper entryEntityMapper = new EntryEntityMapper();
    private PronunciationEntityMapper pronunciationEntityMapper = new PronunciationEntityMapper();

    public LexicalEntry transform(EntryResponseEntity entryResponseEntity){
        LexicalEntryEntity from = entryResponseEntity.getResultEntities().get(0).getLexicalEntries().get(0);
        Result result = new Result();

        LexicalEntry lexicalEntry = new LexicalEntry();
        lexicalEntry.setLanguage(from.getLanguage());
        lexicalEntry.setLexicalCategory(from.getLexicalCategory());
        lexicalEntry.setText(from.getText());
        lexicalEntry.setEntries(entryEntityMapper.mapEntries(from.getEntries()));
        lexicalEntry.setPronunciationEntities(pronunciationEntityMapper.mapPronunciations(from.getPronunciationEntities()));
        return lexicalEntry;
    }*/
}
