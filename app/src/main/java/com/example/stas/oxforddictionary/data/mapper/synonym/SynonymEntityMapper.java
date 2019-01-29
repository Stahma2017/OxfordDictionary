package com.example.stas.oxforddictionary.data.mapper.synonym;

import com.example.stas.oxforddictionary.data.entity.synonym.SynonymEntity;
import com.example.stas.oxforddictionary.domain.model.synonym.Synonym;

import java.util.ArrayList;
import java.util.List;

class SynonymEntityMapper {

    private Synonym mapSynonym(SynonymEntity from){
        return new Synonym(
                from.getId(),
                from.getLanguage(),
                from.getText()
        );
    }

     List<Synonym> mapSynonyms(List<SynonymEntity> fromList){
         List<Synonym> synonyms = new ArrayList<>();
         if (fromList != null){
             for (SynonymEntity synonym : fromList) {
                 synonyms.add(mapSynonym(synonym));
             }
         }
         return synonyms;
     }
}
