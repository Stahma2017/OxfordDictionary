package com.example.stas.oxforddictionary.presentation.mapper.definition;

import com.example.stas.oxforddictionary.domain.model.definition.LexicalEntry;
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.LexicalEntryModel;

import java.util.ArrayList;
import java.util.List;

class LexicalEntryModelMapper {

    private EntryModelMapper entryModelMapper = new EntryModelMapper();
    private PronunciationModelMapper pronunciationModelMapper = new PronunciationModelMapper();

    private LexicalEntryModel mapLexicalEntry(LexicalEntry from){
        return new LexicalEntryModel(
                entryModelMapper.mapEntries(from.getEntries()),
                from.getLanguage(),
                from.getLexicalCategory(),
                pronunciationModelMapper.mapPronunciations(from.getPronunciations()),
                from.getText()
        );
    }

    List<LexicalEntryModel> mapLexicalEntries(List<LexicalEntry> fromList){
        List<LexicalEntryModel> lexicalEntries = new ArrayList<>();
        if(fromList != null){
            for (LexicalEntry lexicalEntry: fromList) {
                lexicalEntries.add(mapLexicalEntry(lexicalEntry));
            }
        }
        return lexicalEntries;
    }
}
