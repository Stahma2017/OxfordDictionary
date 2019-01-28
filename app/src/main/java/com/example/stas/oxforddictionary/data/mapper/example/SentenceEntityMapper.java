package com.example.stas.oxforddictionary.data.mapper.example;

import com.example.stas.oxforddictionary.data.entity.example.SentenceEntity;
import com.example.stas.oxforddictionary.domain.model.example.Sentence;

import java.util.ArrayList;
import java.util.List;

class SentenceEntityMapper {

    private TranslationEntityMapper translationEntityMapper = new TranslationEntityMapper();

    private Sentence mapSentence(SentenceEntity from){
        return new Sentence(
                from.getDefinitions(),
                from.getDomains(),
                from.getRegions(),
                from.getRegisters(),
                from.getSenseIds(),
                from.getText(),
                translationEntityMapper.mapTranslations(from.getTranslations())
        );
    }

  List<Sentence> mapSentences(List<SentenceEntity> fromList){
      List<Sentence> sentences = new ArrayList<>();
      for (SentenceEntity sentence:fromList) {
          sentences.add(mapSentence(sentence));
      }
      return sentences;
  }
}
