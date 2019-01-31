package com.example.stas.oxforddictionary.di.main

import com.example.stas.oxforddictionary.data.mapper.definition.DefinitionEntityDataMapper
import com.example.stas.oxforddictionary.data.mapper.example.ExampleEntityDataMapper
import com.example.stas.oxforddictionary.data.mapper.synonym.SynonymEntityDataMapper
import com.example.stas.oxforddictionary.data.network.OxfordApi
import com.example.stas.oxforddictionary.data.repository.DefinitionRepositoryImp
import com.example.stas.oxforddictionary.di.entry.EntryComponent
import com.example.stas.oxforddictionary.di.example.ExampleComponent
import com.example.stas.oxforddictionary.di.synonym.SynonymComponent
import com.example.stas.oxforddictionary.domain.DefinitionRepository
import com.example.stas.oxforddictionary.domain.interactor.DefinitonInteractor
import com.example.stas.oxforddictionary.presentation.presenter.main.MainPresenter
import com.example.stas.oxforddictionary.presentation.view.main.MainActivity
import com.example.stas.oxforddictionary.presentation.view.main.MainContract
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Subcomponent(modules = [MainModule::class, DefinitionModule::class])
interface MainComponent {
    fun injectMainActivity(activity: MainActivity)
    fun addEntryComponent(): EntryComponent
    fun addExampleComponent(): ExampleComponent
    fun addSynonymComponent(): SynonymComponent
}

@Module
class MainModule{
    @Provides
    fun provideMainPresenter(): MainContract.Presenter = MainPresenter()
}

@Module
class DefinitionModule{
    @Provides
    fun provideDefinitionInteractor(repository: DefinitionRepository): DefinitonInteractor =
        DefinitonInteractor(repository)

    @Provides
    fun provideDefinitionRepository(oxfordApi: OxfordApi,
                                    definitionEntityDataMapper: DefinitionEntityDataMapper,
                                    synonymEntityDataMapper: SynonymEntityDataMapper,
                                    exampleEntityDataMapper: ExampleEntityDataMapper): DefinitionRepository {
       return DefinitionRepositoryImp(oxfordApi, definitionEntityDataMapper,
                synonymEntityDataMapper, exampleEntityDataMapper)
    }

    @Provides
    fun provideDefinitionMapper(): DefinitionEntityDataMapper =
        DefinitionEntityDataMapper()

    @Provides
    fun provideSynonymMapper(): SynonymEntityDataMapper =
       SynonymEntityDataMapper()

    @Provides
    fun provideExampleMapper(): ExampleEntityDataMapper =
            ExampleEntityDataMapper()
}

