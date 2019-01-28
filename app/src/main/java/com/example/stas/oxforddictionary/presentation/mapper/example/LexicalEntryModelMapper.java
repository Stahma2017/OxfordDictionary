package com.example.stas.oxforddictionary.presentation.mapper.example;

import com.example.stas.oxforddictionary.domain.model.example.LexicalEntry;
import com.example.stas.oxforddictionary.presentation.viewmodel.example.LexicalEntryModel;

import java.util.ArrayList;
import java.util.List;

class LexicalEntryModelMapper {
    private SentenceModelMapper sentenceModelMapper = new SentenceModelMapper();

    private LexicalEntryModel mapLexicalEntry(LexicalEntry from){
        LexicalEntryModel lexicalEntry = new LexicalEntryModel();
        lexicalEntry.setLanguage(from.getLanguage());
        lexicalEntry.setLexicalCategory(from.getLexicalCategory());
        lexicalEntry.setText(from.getText());
        lexicalEntry.setSentences(sentenceModelMapper.mapSentences(from.getSenteces()));
        return lexicalEntry;
    }

    List<LexicalEntryModel> mapLexicalEntries(List<LexicalEntry> fromList){
        List<LexicalEntryModel> lexicalEntries = new ArrayList<>();
        for (LexicalEntry lexicalEntry: fromList) {
            lexicalEntries.add(mapLexicalEntry(lexicalEntry));
        }
        return lexicalEntries;
    }
}
