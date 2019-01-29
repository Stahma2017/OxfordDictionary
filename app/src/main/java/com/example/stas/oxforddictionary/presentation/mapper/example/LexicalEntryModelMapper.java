package com.example.stas.oxforddictionary.presentation.mapper.example;

import com.example.stas.oxforddictionary.domain.model.example.LexicalEntry;
import com.example.stas.oxforddictionary.presentation.viewmodel.example.LexicalEntryModel;

import java.util.ArrayList;
import java.util.List;

class LexicalEntryModelMapper {
    private SentenceModelMapper sentenceModelMapper = new SentenceModelMapper();

    private LexicalEntryModel mapLexicalEntry(LexicalEntry from){
        return new LexicalEntryModel(
                from.getLanguage(),
                from.getLexicalCategory(),
                sentenceModelMapper.mapSentences(from.getSenteces()),
                from.getText()
        );
    }

    List<LexicalEntryModel> mapLexicalEntries(List<LexicalEntry> fromList){
        List<LexicalEntryModel> lexicalEntries = new ArrayList<>();
        if (fromList != null){
            for (LexicalEntry lexicalEntry: fromList) {
                lexicalEntries.add(mapLexicalEntry(lexicalEntry));
            }
        }
        return lexicalEntries;
    }
}
