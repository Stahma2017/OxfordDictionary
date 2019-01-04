package com.example.stas.oxforddictionary.data.mapper.example;

import com.example.stas.oxforddictionary.data.entity.example.TranslationEntity;
import com.example.stas.oxforddictionary.domain.model.example.Translation;

import java.util.ArrayList;
import java.util.List;

class TranslationEntityMapper {

    private Translation mapTranslation(TranslationEntity from){
        Translation translation = new Translation();
        translation.setDomains(from.getDomains());
        translation.setLanguage(from.getLanguage());
        translation.setRegions(from.getRegisters());
        translation.setRegisters(from.getRegisters());
        translation.setText(from.getText());
        return translation;
    }

   List<Translation> mapTranslations(List<TranslationEntity> fromList){
       List<Translation> translations = new ArrayList<>();
       for (TranslationEntity translation :fromList) {
           translations.add(mapTranslation(translation));
       }
       return translations;
    }
}
