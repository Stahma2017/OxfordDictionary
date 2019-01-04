package com.example.stas.oxforddictionary.presentation.mapper.example;

import com.example.stas.oxforddictionary.domain.model.example.Translation;
import com.example.stas.oxforddictionary.presentation.viewmodel.example.TranslationModel;

import java.util.ArrayList;
import java.util.List;

public class TranslationModelMapper {
    private TranslationModel mapTranslation(Translation from){
        TranslationModel translation = new TranslationModel();
        translation.setDomains(from.getDomains());
        translation.setLanguage(from.getLanguage());
        translation.setRegions(from.getRegisters());
        translation.setRegisters(from.getRegisters());
        translation.setText(from.getText());
        return translation;
    }

    List<TranslationModel> mapTranslations(List<Translation> fromList){
        List<TranslationModel> translations = new ArrayList<>();
        for (Translation translation : fromList) {
            translations.add(mapTranslation(translation));
        }
        return translations;
    }
}
