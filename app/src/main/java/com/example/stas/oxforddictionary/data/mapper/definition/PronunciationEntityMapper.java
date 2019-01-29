package com.example.stas.oxforddictionary.data.mapper.definition;

import com.example.stas.oxforddictionary.data.entity.definition.PronunciationEntity;
import com.example.stas.oxforddictionary.domain.model.definition.Pronunciation;

import java.util.ArrayList;
import java.util.List;

class PronunciationEntityMapper {

    private Pronunciation mapPronunciation(PronunciationEntity from){
        Pronunciation pronunciation = new Pronunciation();
        pronunciation.setAudioFile(from.getAudioFile());
        pronunciation.setDialects(from.getDialects());
        pronunciation.setPhoneticNotation(from.getPhoneticNotation());
        pronunciation.setPhoneticSpelling(from.getPhoneticSpelling());
        return pronunciation;
    }

    List<Pronunciation> mapPronunciations(List<PronunciationEntity> fromList){
            List<Pronunciation> pronunciations = new ArrayList<>();
            if (fromList != null){
                for (PronunciationEntity pronunciationEntity : fromList) {
                    pronunciations.add(mapPronunciation(pronunciationEntity));
                }
            }
            return pronunciations;
    }
}
