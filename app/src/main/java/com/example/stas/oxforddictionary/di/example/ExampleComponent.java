package com.example.stas.oxforddictionary.di.example;

import com.example.stas.oxforddictionary.presentation.view.example.ExampleActivity;
import dagger.Subcomponent;

@Subcomponent(modules = {ExampleModule.class})
public interface ExampleComponent {
    void injectExampleActivity(ExampleActivity exampleActivity);
}
