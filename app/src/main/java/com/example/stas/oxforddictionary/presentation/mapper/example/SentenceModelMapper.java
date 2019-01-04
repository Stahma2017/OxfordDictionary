package com.example.stas.oxforddictionary.presentation.mapper.example;

import com.example.stas.oxforddictionary.domain.model.example.Sentence;
import com.example.stas.oxforddictionary.presentation.viewmodel.example.SentenceModel;

import java.util.ArrayList;
import java.util.List;

class SentenceModelMapper {
    private TranslationModelMapper translationModelMapper = new TranslationModelMapper();

    private SentenceModel mapSentence(Sentence from){
        SentenceModel sentence = new SentenceModel();
        sentence.setDefinitions(from.getDefinitions());
        sentence.setDomains(from.getDomains());
        sentence.setRegions(from.getRegions());
        sentence.setRegisters(from.getRegisters());
        sentence.setSenseIds(from.getSenseIds());
        sentence.setText(from.getText());
        sentence.setTranslations(translationModelMapper.mapTranslations(from.getTranslations()));
        return sentence;
    }

    List<SentenceModel> mapSentences(List<Sentence> fromList){
        List<SentenceModel> sentences = new ArrayList<>();
        for (Sentence sentence:fromList) {
            sentences.add(mapSentence(sentence));
        }
        return sentences;
    }
}
