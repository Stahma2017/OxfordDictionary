package com.example.stas.oxforddictionary.presentation.mapper.synonym;

import com.example.stas.oxforddictionary.domain.model.synonym.Synonym;
import com.example.stas.oxforddictionary.presentation.viewmodel.synonym.SynonymModel;

import java.util.ArrayList;
import java.util.List;

class SynonymModelMapper {

    private SynonymModel mapSynonym(Synonym from){
        SynonymModel synonymModel = new SynonymModel();
        synonymModel.setId(from.getId());
        synonymModel.setLanguage(from.getLanguage());
        synonymModel.setText(from.getText());
        return synonymModel;
    }


    List<SynonymModel> mapSynonyms(List<Synonym> fromList){
        List<SynonymModel> synonyms = new ArrayList<>();
        for (Synonym synonym: fromList) {
            synonyms.add(mapSynonym(synonym));
        }
        return synonyms;
    }
}
