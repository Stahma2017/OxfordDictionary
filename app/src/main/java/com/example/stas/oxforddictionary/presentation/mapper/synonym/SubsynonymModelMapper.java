package com.example.stas.oxforddictionary.presentation.mapper.synonym;

import com.example.stas.oxforddictionary.domain.model.synonym.Subsynonym;
import com.example.stas.oxforddictionary.presentation.viewmodel.synonym.SubsynonymModel;

import java.util.ArrayList;
import java.util.List;

class SubsynonymModelMapper {

    private SubsynonymModel mapSubsynonym(Subsynonym from){
        return new SubsynonymModel(
                from.getId(),
                from.getLanguage(),
                from.getText()
        );
    }

    List<SubsynonymModel> mapSubsynonyms(List<Subsynonym> fromList){
        List<SubsynonymModel> subSynonyms = new ArrayList<>();
        for (Subsynonym subSynonym: fromList) {
            subSynonyms.add(mapSubsynonym(subSynonym));
        }
        return subSynonyms;
    }
}
