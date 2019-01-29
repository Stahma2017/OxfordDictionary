package com.example.stas.oxforddictionary.data.mapper.synonym;

import com.example.stas.oxforddictionary.data.entity.synonym.SubSynonymEntity;
import com.example.stas.oxforddictionary.domain.model.synonym.Subsynonym;

import java.util.ArrayList;
import java.util.List;

class SubSynonymEntityMapper {

    private Subsynonym mapSynonym(SubSynonymEntity from){
        return new Subsynonym(
                from.getId(),
                from.getLanguage(),
                from.getText()
        );
    }

   List<Subsynonym> mapSynonyms(List<SubSynonymEntity> fromList){
        List<Subsynonym> subSynonyms = new ArrayList<>();
        if(fromList != null){
            for (SubSynonymEntity subsynonym: fromList) {
                subSynonyms.add(mapSynonym(subsynonym));
            }
        }
       return subSynonyms;
    }
}
