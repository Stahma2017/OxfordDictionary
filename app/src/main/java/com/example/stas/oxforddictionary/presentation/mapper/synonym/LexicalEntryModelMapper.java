package com.example.stas.oxforddictionary.presentation.mapper.synonym;

import com.example.stas.oxforddictionary.domain.model.synonym.LexicalEntry;
import com.example.stas.oxforddictionary.presentation.viewmodel.synonym.LexicalEntryModel;

import java.util.ArrayList;
import java.util.List;

class LexicalEntryModelMapper {

        private EntryModelMapper entryModelMapper = new EntryModelMapper();

    private LexicalEntryModel mapLexicalEntry(LexicalEntry from){
        LexicalEntryModel lexicalEntryModel = new LexicalEntryModel();
        lexicalEntryModel.setLanguage(from.getLanguage());
        lexicalEntryModel.setLexicalCategory(from.getLexicalCategory());
        lexicalEntryModel.setText(from.getText());
        lexicalEntryModel.setEntries(entryModelMapper.mapEntries(from.getEntries()));
        return  lexicalEntryModel;
    }


    List<LexicalEntryModel> mapLexicalEntries(List<LexicalEntry> fromList){
        List<LexicalEntryModel> lexicalEntries = new ArrayList<>();
        for (LexicalEntry lexEntry: fromList) {
            lexicalEntries.add(mapLexicalEntry(lexEntry));
        }
        return lexicalEntries;
    }

}
