package com.example.stas.oxforddictionary.presentation.mapper.synonym;

import com.example.stas.oxforddictionary.domain.model.synonym.SubSynonym;
import com.example.stas.oxforddictionary.presentation.viewmodel.synonym.SubSynonymModel;

import java.util.ArrayList;
import java.util.List;

class SubsynonymModelMapper {

    private SubSynonymModel mapSubsynonym(SubSynonym from){
        SubSynonymModel subSynonymModel = new SubSynonymModel();
        subSynonymModel.setId(from.getId());
        subSynonymModel.setLanguage(from.getLanguage());
        subSynonymModel.setText(from.getText());
        return subSynonymModel;
    }

    List<SubSynonymModel> mapSubsynonyms(List<SubSynonym> fromList){
        List<SubSynonymModel> subSynonyms = new ArrayList<>();
        for (SubSynonym subSynonym: fromList) {
            subSynonyms.add(mapSubsynonym(subSynonym));
        }
        return subSynonyms;
    }
}
