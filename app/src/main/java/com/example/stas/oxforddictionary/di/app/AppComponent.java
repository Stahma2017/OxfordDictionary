package com.example.stas.oxforddictionary.di.app;

import com.example.stas.oxforddictionary.di.main.MainComponent;

import dagger.Component;

@Component(modules={AppModule.class, ErrorHandlerModule.class, NetworkModule.class, RxModule.class})
public interface AppComponent {
    MainComponent addMainComponent();
}
