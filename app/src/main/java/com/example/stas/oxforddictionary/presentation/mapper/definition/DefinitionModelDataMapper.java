package com.example.stas.oxforddictionary.presentation.mapper.definition;

import com.example.stas.oxforddictionary.domain.model.definition.LexicalEntry;
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.LexicalEntryModel;

public class DefinitionModelDataMapper {
    private EntryModelMapper entryModelMapper = new EntryModelMapper();
    private PronunciationModelMapper pronunciationModelMapper = new PronunciationModelMapper();

    public LexicalEntryModel transform(LexicalEntry from){
        LexicalEntryModel lexicalEntryModel = new LexicalEntryModel();
        lexicalEntryModel.setLanguage(from.getLanguage());
        lexicalEntryModel.setLexicalCategory(from.getLexicalCategory());
        lexicalEntryModel.setText(from.getText());
        lexicalEntryModel.setEntries(entryModelMapper.mapEntries(from.getEntries()));
        lexicalEntryModel.setPronunciationEntities(pronunciationModelMapper.mapPronunciations(from.getPronunciationEntities()));
        return lexicalEntryModel;
    }
}
