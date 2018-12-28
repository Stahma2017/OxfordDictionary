package com.example.stas.oxforddictionary.data.mapper.synonym;

import com.example.stas.oxforddictionary.data.entity.synonym.SynonymEntity;
import com.example.stas.oxforddictionary.domain.model.synonym.Synonym;

import java.util.ArrayList;
import java.util.List;

public class SynonymEntityMapper {

    private Synonym mapSynonym(SynonymEntity from){
        Synonym synonym = new Synonym();
        synonym.setId(from.getId());
        synonym.setLanguage(from.getLanguage());
        synonym.setText(from.getText());
        return synonym;
    }


     List<Synonym> mapSynonyms(List<SynonymEntity> fromList){
         List<Synonym> synonyms = new ArrayList<>();
         for (SynonymEntity synonym : fromList) {
             synonyms.add(mapSynonym(synonym));
         }
         return synonyms;
     }
}
