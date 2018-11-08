package com.example.stas.oxforddictionary.data.mapper;

import com.example.stas.oxforddictionary.data.entity.definition.PronunciationEntity;
import com.example.stas.oxforddictionary.domain.model.definition.Pronunciation;

import java.util.ArrayList;
import java.util.List;

public class PronunciationEntityMapper {

    public Pronunciation mapPronunciation(PronunciationEntity from){
        Pronunciation pronunciation = new Pronunciation();
        pronunciation.setAudioFile(from.getAudioFile());
        pronunciation.setDialects(from.getDialects());
        pronunciation.setPhoneticNotation(from.getPhoneticNotation());
        pronunciation.setPhoneticSpelling(from.getPhoneticSpelling());
        return pronunciation;
    }

    public List<Pronunciation> mapPronunciations(List<PronunciationEntity> fromList){
        List<Pronunciation> pronunciations = new ArrayList<>();
        for (PronunciationEntity pronunciationEntity : fromList) {
            pronunciations.add(mapPronunciation(pronunciationEntity));
        }
        return pronunciations;
    }
}
