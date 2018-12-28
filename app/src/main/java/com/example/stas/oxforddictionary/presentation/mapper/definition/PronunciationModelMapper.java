package com.example.stas.oxforddictionary.presentation.mapper.definition;

import com.example.stas.oxforddictionary.domain.model.definition.Pronunciation;
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.PronunciationModel;

import java.util.ArrayList;
import java.util.List;

public class PronunciationModelMapper {
    public PronunciationModel mapPronunciation(Pronunciation from){
        PronunciationModel pronunciation = new PronunciationModel();
        pronunciation.setAudioFile(from.getAudioFile());
        pronunciation.setDialects(from.getDialects());
        pronunciation.setPhoneticNotation(from.getPhoneticNotation());
        pronunciation.setPhoneticSpelling(from.getPhoneticSpelling());
        return pronunciation;
    }

    public List<PronunciationModel> mapPronunciations(List<Pronunciation> fromList){
        List<PronunciationModel> pronunciations = new ArrayList<>();
        for (Pronunciation pronunciation : fromList) {
            pronunciations.add(mapPronunciation(pronunciation));
        }
        return pronunciations;
    }
}
