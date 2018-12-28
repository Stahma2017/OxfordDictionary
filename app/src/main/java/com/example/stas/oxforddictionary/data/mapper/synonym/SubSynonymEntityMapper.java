package com.example.stas.oxforddictionary.data.mapper.synonym;

import com.example.stas.oxforddictionary.data.entity.synonym.SubSynonymEntity;
import com.example.stas.oxforddictionary.domain.model.synonym.SubSynonym;

import java.util.ArrayList;
import java.util.List;

class SubSynonymEntityMapper {

    private SubSynonym mapSynonym(SubSynonymEntity from){
        SubSynonym subSynonym = new SubSynonym();
        subSynonym.setId(from.getId());
        subSynonym.setLanguage(from.getLanguage());
        subSynonym.setText(from.getText());
        return subSynonym;
    }

   List<SubSynonym> mapSynonyms(List<SubSynonymEntity> fromList){
        List<SubSynonym> subSynonyms = new ArrayList<>();
       for (SubSynonymEntity subsynonym: fromList) {
           subSynonyms.add(mapSynonym(subsynonym));
       }
       return subSynonyms;
    }
}
