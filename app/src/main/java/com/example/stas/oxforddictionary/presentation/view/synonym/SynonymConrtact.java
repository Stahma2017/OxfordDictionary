package com.example.stas.oxforddictionary.presentation.view.synonym;

import com.example.stas.oxforddictionary.presentation.view.base.CanShowError;
import com.example.stas.oxforddictionary.presentation.view.synonym.adapter.SynonymsItem;

import java.util.List;

public interface SynonymConrtact {
    interface View extends CanShowError {
        void showSynonyms(List<SynonymsItem> synonyms);
    }
    interface Presenter {
        void attachView(SynonymConrtact.View view);
        void detachView();
        void getSynonyms(String word);
    }
}
