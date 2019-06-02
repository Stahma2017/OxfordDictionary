package com.example.stas.oxforddictionary.di.main

import com.example.stas.oxforddictionary.data.database.dao.SavedWordDao
import com.example.stas.oxforddictionary.data.database.dao.ViewedWordDao
import com.example.stas.oxforddictionary.data.database.dao.WeekStatisticDao
import com.example.stas.oxforddictionary.data.network.OxfordApi
import com.example.stas.oxforddictionary.data.repository.DefinitionRepositoryImp
import com.example.stas.oxforddictionary.data.repository.StatisticRepositoryImp
import com.example.stas.oxforddictionary.di.entry.EntryComponent
import com.example.stas.oxforddictionary.di.example.ExampleComponent
import com.example.stas.oxforddictionary.di.practice.PracticeComponent
import com.example.stas.oxforddictionary.di.save.SaveComponent
import com.example.stas.oxforddictionary.di.statistic.StatisticComponent
import com.example.stas.oxforddictionary.di.synonym.SynonymComponent
import com.example.stas.oxforddictionary.domain.DefinitionRepository
import com.example.stas.oxforddictionary.domain.StatisticRepository
import com.example.stas.oxforddictionary.domain.usecase.DefinitonInteractor
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
    fun addSaveComponent(): SaveComponent
    fun addPracticeComponent(): PracticeComponent
    fun addStatisticComponent(): StatisticComponent
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
    fun provideDefinitionRepository(oxfordApi: OxfordApi, savedWordDao: SavedWordDao,
                                    viewedWordDao: ViewedWordDao): DefinitionRepository {
       return DefinitionRepositoryImp(oxfordApi, savedWordDao, viewedWordDao)
    }

    @Provides
    fun provideStatisticRepository(weekStatisticDao: WeekStatisticDao): StatisticRepository {
        return StatisticRepositoryImp(weekStatisticDao)
    }

}


