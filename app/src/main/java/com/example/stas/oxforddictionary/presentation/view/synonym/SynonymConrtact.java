package com.example.stas.oxforddictionary.presentation.view.synonym;

import com.example.stas.oxforddictionary.presentation.view.base.CanShowError;

public interface SynonymConrtact {
    interface View extends CanShowError {

    }
    interface Presenter {
        void detachView();
    }
}
