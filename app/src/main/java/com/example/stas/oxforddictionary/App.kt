package com.example.stas.oxforddictionary

import android.app.Application
import com.example.stas.oxforddictionary.di.app.ApplicationComponent
import com.example.stas.oxforddictionary.di.app.ApplicationModule
import com.example.stas.oxforddictionary.di.app.DaggerApplicationComponent
import com.example.stas.oxforddictionary.di.entry.EntryComponent
import com.example.stas.oxforddictionary.di.example.ExampleComponent
import com.example.stas.oxforddictionary.di.main.MainComponent
import com.example.stas.oxforddictionary.di.save.SaveComponent
import com.example.stas.oxforddictionary.di.synonym.SynonymComponent
import com.squareup.leakcanary.LeakCanary

class App : Application() {

   private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        LeakCanary.install(this)
    }

    private var mainComponent: MainComponent? = null
    private var entryComponent: EntryComponent? = null
    private var exampleComponent: ExampleComponent? = null
    private var synonymComponent: SynonymComponent? = null
    private var saveComponent: SaveComponent? = null

    fun createMaincomponent(): MainComponent {
        if (mainComponent == null) {
            mainComponent = applicationComponent.addMainComponent()
        }
        return mainComponent!!
    }

    fun createEntryComponent(): EntryComponent {
        if (entryComponent == null) {
            entryComponent = mainComponent?.addEntryComponent()
        }
        return entryComponent!!
    }

    fun createExampleComponent(): ExampleComponent {
        if (exampleComponent == null) {
            exampleComponent = mainComponent?.addExampleComponent()
        }
        return exampleComponent!!
    }

    fun createSynonymComponent(): SynonymComponent {
        if (synonymComponent == null) {
            synonymComponent = mainComponent?.addSynonymComponent()
        }
        return synonymComponent!!
    }

    fun createSaveComponent(): SaveComponent{
        if (saveComponent == null){
            saveComponent = mainComponent?.addSaveComponent()
        }
        return saveComponent!!
    }
}