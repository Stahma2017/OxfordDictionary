package com.example.stas.oxforddictionary.presentation.mapper.example;

import com.example.stas.oxforddictionary.domain.model.example.Translation;
import com.example.stas.oxforddictionary.presentation.viewmodel.example.TranslationModel;

import java.util.ArrayList;
import java.util.List;

class TranslationModelMapper {
    private TranslationModel mapTranslation(Translation from){
        return new TranslationModel(
                from.getDomains(),
                from.getLanguage(),
                from.getRegions(),
                from.getRegisters(),
                from.getText()
        );
    }

    List<TranslationModel> mapTranslations(List<Translation> fromList){
        List<TranslationModel> translations = new ArrayList<>();
        if (fromList != null){
            for (Translation translation : fromList) {
                translations.add(mapTranslation(translation));
            }
        }
        return translations;
    }
}
