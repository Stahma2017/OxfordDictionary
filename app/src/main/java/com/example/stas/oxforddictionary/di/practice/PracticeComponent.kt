package com.example.stas.oxforddictionary.di.practice

import com.example.stas.oxforddictionary.domain.DefinitionRepository
import com.example.stas.oxforddictionary.domain.StatisticRepository
import com.example.stas.oxforddictionary.domain.usecase.definition.FetchSavedWordsUseCase
import com.example.stas.oxforddictionary.domain.usecase.definition.UpdateSavedWordsUseCase
import com.example.stas.oxforddictionary.domain.usecase.statistic.UpdateWeekStatisticUseCase
import com.example.stas.oxforddictionary.presentation.presenter.practice.PracticePresenter
import com.example.stas.oxforddictionary.presentation.view.base.ErrorHandler
import com.example.stas.oxforddictionary.presentation.view.practice.PracticeContract
import com.example.stas.oxforddictionary.presentation.view.practice.PracticeFragment
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import io.reactivex.disposables.CompositeDisposable

@Subcomponent(modules = [PracticeModule::class])
interface PracticeComponent{
    fun injectPracticeFragment(practiceFragment: PracticeFragment)
}

@Module
class PracticeModule{
    @Provides
    fun providePracticePresenter(errorHandler: ErrorHandler,
                                 compositeDisposable: CompositeDisposable,
                                 fetchSavedWordsUseCase: FetchSavedWordsUseCase,
                                 updateSavedWordsUseCase: UpdateSavedWordsUseCase,
                                 updateWeekStatisticUseCase: UpdateWeekStatisticUseCase): PracticeContract.Presenter{
        return PracticePresenter(errorHandler, compositeDisposable, fetchSavedWordsUseCase, updateSavedWordsUseCase, updateWeekStatisticUseCase)
    }

    @Provides
    fun provideFetchSavedWordsUseCase(definitionRepository: DefinitionRepository): FetchSavedWordsUseCase{
        return FetchSavedWordsUseCase(definitionRepository)
    }

    @Provides
    fun provideUpdateSavedWordsUseCase(definitionRepository: DefinitionRepository): UpdateSavedWordsUseCase{
        return UpdateSavedWordsUseCase(definitionRepository)
    }

    @Provides
    fun provideUpdateWeekStatisticUseCase(statisticRepository: StatisticRepository): UpdateWeekStatisticUseCase{
        return UpdateWeekStatisticUseCase(statisticRepository)
    }
}