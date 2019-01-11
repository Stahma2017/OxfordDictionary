package com.example.stas.oxforddictionary.di.entry;

import com.example.stas.oxforddictionary.presentation.view.entry.EntryFragment;
import dagger.Subcomponent;

@Subcomponent(modules = {EntryModule.class})
public interface EntryComponent {
    void injectEntryFragment(EntryFragment entryFragment);
}
