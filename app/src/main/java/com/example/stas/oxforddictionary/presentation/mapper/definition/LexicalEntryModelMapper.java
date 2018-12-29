package com.example.stas.oxforddictionary.presentation.mapper.definition;

import com.example.stas.oxforddictionary.domain.model.definition.LexicalEntry;
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.LexicalEntryModel;

import java.util.ArrayList;
import java.util.List;

class LexicalEntryModelMapper {

    private EntryModelMapper entryModelMapper = new EntryModelMapper();
    private PronunciationModelMapper pronunciationModelMapper = new PronunciationModelMapper();

    private LexicalEntryModel mapLexicalEntry(LexicalEntry from){
        LexicalEntryModel lexicalEntryModel = new LexicalEntryModel();
        lexicalEntryModel.setLanguage(from.getLanguage());
        lexicalEntryModel.setLexicalCategory(from.getLexicalCategory());
        lexicalEntryModel.setText(from.getText());
        lexicalEntryModel.setEntries(entryModelMapper.mapEntries(from.getEntries()));
        lexicalEntryModel.setPronunciationEntities(pronunciationModelMapper.mapPronunciations(from.getPronunciationEntities()));
   return lexicalEntryModel;
    }

    List<LexicalEntryModel> mapLexicalEntries(List<LexicalEntry> fromList){
        List<LexicalEntryModel> lexicalEntries = new ArrayList<>();
        for (LexicalEntry lexicalEntry: fromList) {
            lexicalEntries.add(mapLexicalEntry(lexicalEntry));
        }
        return lexicalEntries;
    }
}
