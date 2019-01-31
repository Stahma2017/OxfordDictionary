package com.example.stas.oxforddictionary;

import android.app.Application;

import com.example.stas.oxforddictionary.di.app.ApplicationComponent;
import com.example.stas.oxforddictionary.di.app.ApplicationModule;
import com.example.stas.oxforddictionary.di.app.DaggerApplicationComponent;
import com.example.stas.oxforddictionary.di.entry.EntryComponent;
import com.example.stas.oxforddictionary.di.example.ExampleComponent;
import com.example.stas.oxforddictionary.di.main.MainComponent;
import com.example.stas.oxforddictionary.di.synonym.SynonymComponent;
import com.squareup.leakcanary.LeakCanary;

public class App extends Application {

    protected static App instance;
    private ApplicationComponent component;
    private MainComponent mainComponent;
    private EntryComponent entryComponent;
    private ExampleComponent exampleComponent;
    private SynonymComponent synonymComponent;

    public static App getInstance(){
        return instance;
    }

    @Override public void onCreate() {
        super.onCreate();
        instance = this;
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    public ApplicationComponent getComponent() {
        return component;
    }

    public MainComponent getMainComponent(){
        if (mainComponent == null){
            mainComponent = component.addMainComponent();
        }
        return mainComponent;
    }

    public EntryComponent getEntryComonent(){
        if(entryComponent == null){
            entryComponent = mainComponent.addEntryComponent();
        }
        return entryComponent;
    }

    public ExampleComponent getExampleComponent(){
        if(exampleComponent == null){
            exampleComponent = mainComponent.addExampleComponent();
        }
        return exampleComponent;
    }

    public SynonymComponent getSynonymComponent(){
        if(synonymComponent == null){
            synonymComponent = mainComponent.addSynonymComponent();
        }
        return synonymComponent;
    }
}
