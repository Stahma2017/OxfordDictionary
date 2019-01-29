package com.example.stas.oxforddictionary.presentation.mapper.definition;

import com.example.stas.oxforddictionary.domain.model.definition.Pronunciation;
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.PronunciationModel;

import java.util.ArrayList;
import java.util.List;

class PronunciationModelMapper {
    private PronunciationModel mapPronunciation(Pronunciation from){
        return new PronunciationModel(
                from.getAudioFile(),
                from.getDialects(),
                from.getPhoneticNotation(),
                from.getPhoneticSpelling()
        );
    }

    List<PronunciationModel> mapPronunciations(List<Pronunciation> fromList){
        List<PronunciationModel> pronunciations = new ArrayList<>();
        if (fromList != null){
            for (Pronunciation pronunciation : fromList) {
                pronunciations.add(mapPronunciation(pronunciation));
            }
        }
        return pronunciations;
    }
}
