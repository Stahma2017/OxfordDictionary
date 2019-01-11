package com.example.stas.oxforddictionary.di.synonym;

import com.example.stas.oxforddictionary.presentation.view.synonym.SynonymActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {SynonymModule.class})
public interface SynonymComponent {
    void injectSynonymActivity(SynonymActivity synonymActivity);
}
