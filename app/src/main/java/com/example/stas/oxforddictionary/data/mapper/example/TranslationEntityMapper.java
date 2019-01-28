package com.example.stas.oxforddictionary.data.mapper.example;

import com.example.stas.oxforddictionary.data.entity.example.TranslationEntity;
import com.example.stas.oxforddictionary.domain.model.example.Translation;

import java.util.ArrayList;
import java.util.List;

class TranslationEntityMapper {

    private Translation mapTranslation(TranslationEntity from){
        return new Translation(
                from.getDomains(),
                from.getLanguage(),
                from.getRegions(),
                from.getRegisters(),
                from.getText()
        );
    }

   List<Translation> mapTranslations(List<TranslationEntity> fromList){
       List<Translation> translations = new ArrayList<>();
       if (fromList!= null){
           for (TranslationEntity translation :fromList) {
               translations.add(mapTranslation(translation));
           }
       }
       return translations;
    }
}
