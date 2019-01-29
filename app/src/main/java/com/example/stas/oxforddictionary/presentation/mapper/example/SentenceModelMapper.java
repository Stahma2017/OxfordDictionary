package com.example.stas.oxforddictionary.presentation.mapper.example;

import com.example.stas.oxforddictionary.domain.model.example.Sentence;
import com.example.stas.oxforddictionary.presentation.viewmodel.example.SentenceModel;

import java.util.ArrayList;
import java.util.List;

class SentenceModelMapper {
    private TranslationModelMapper translationModelMapper = new TranslationModelMapper();

    private SentenceModel mapSentence(Sentence from){
        return new SentenceModel(
                from.getDefinitions(),
                from.getDomains(),
                from.getRegions(),
                from.getRegisters(),
                from.getSenseIds(),
                from.getText(),
                translationModelMapper.mapTranslations(from.getTranslations())
        );
    }

    List<SentenceModel> mapSentences(List<Sentence> fromList){
        List<SentenceModel> sentences = new ArrayList<>();
        if (fromList != null){
            for (Sentence sentence:fromList) {
                sentences.add(mapSentence(sentence));
            }
        }
        return sentences;
    }
}
