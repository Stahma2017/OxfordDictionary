package com.example.stas.oxforddictionary.di.main;

import com.example.stas.oxforddictionary.di.entry.EntryComponent;
import com.example.stas.oxforddictionary.presentation.view.main.MainActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {MainModule.class, DefinitionModule.class})
public interface MainComponent {
    void injectMainActivity(MainActivity activity);
    EntryComponent addEntryComponent();


}
