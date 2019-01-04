package com.example.stas.oxforddictionary.data.mapper.example;

import com.example.stas.oxforddictionary.data.entity.example.SentenceEntity;
import com.example.stas.oxforddictionary.domain.model.example.Sentence;

import java.util.ArrayList;
import java.util.List;

class SentenceEntityMapper {

    private TranslationEntityMapper translationEntityMapper = new TranslationEntityMapper();

    private Sentence mapSentence(SentenceEntity from){
        Sentence sentence = new Sentence();
        sentence.setDefinitions(from.getDefinitions());
        sentence.setDomains(from.getDomains());
        sentence.setRegions(from.getRegions());
        sentence.setRegisters(from.getRegisters());
        sentence.setSenseIds(from.getSenseIds());
        sentence.setText(from.getText());
        sentence.setTranslations(translationEntityMapper.mapTranslations(from.getTranslations()));
        return sentence;
    }

  List<Sentence> mapSentences(List<SentenceEntity> fromList){
      List<Sentence> sentences = new ArrayList<>();
      for (SentenceEntity sentence:fromList) {
          sentences.add(mapSentence(sentence));
      }
      return sentences;
  }
}
