package com.example.stas.oxforddictionary.data.mapper;

import com.example.stas.oxforddictionary.data.model.Pronunciation;
import com.example.stas.oxforddictionary.domain.Entity.PronunciationEntity;

import java.util.ArrayList;
import java.util.List;

public class PronunciationMapper {

    public PronunciationEntity mapPronunciation(Pronunciation from){
        PronunciationEntity pronunciationEntity = new PronunciationEntity();
        pronunciationEntity.setAudioFile(from.getAudioFile());
        pronunciationEntity.setDialects(from.getDialects());
        pronunciationEntity.setPhoneticNotation(from.getPhoneticNotation());
        pronunciationEntity.setPhoneticSpelling(from.getPhoneticSpelling());
        return pronunciationEntity;
    }

    public List<PronunciationEntity> mapPronunciations(List<Pronunciation> fromList){
        List<PronunciationEntity> pronunciations = new ArrayList<>();
        for (Pronunciation pronunciation: fromList) {
            pronunciations.add(mapPronunciation(pronunciation));
        }
        return pronunciations;
    }
}
