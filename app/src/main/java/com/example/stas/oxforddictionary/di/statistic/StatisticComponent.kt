package com.example.stas.oxforddictionary.di.statistic

import com.example.stas.oxforddictionary.domain.StatisticRepository
import com.example.stas.oxforddictionary.domain.usecase.statistic.FetchWeekStatisticUseCase
import com.example.stas.oxforddictionary.domain.usecase.statistic.UpdateWeekStatisticUseCase
import com.example.stas.oxforddictionary.presentation.presenter.statistic.StatisticPresenter
import com.example.stas.oxforddictionary.presentation.view.base.ErrorHandler
import com.example.stas.oxforddictionary.presentation.view.statistic.StatisticContract
import com.example.stas.oxforddictionary.presentation.view.statistic.StatisticFragment
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import io.reactivex.disposables.CompositeDisposable

@Subcomponent(modules = [StatisticModule::class])
interface StatisticComponent{
    fun injectStatisticFragment(statisticFragment: StatisticFragment)
}

@Module
class StatisticModule{

    @Provides
    fun provideStatisticPresenter(errorHandler: ErrorHandler,
                                  compositeDisposable: CompositeDisposable,
                                  fetchWeekStatisticUseCase: FetchWeekStatisticUseCase): StatisticContract.Presenter{
        return StatisticPresenter(errorHandler, compositeDisposable, fetchWeekStatisticUseCase)
    }

    @Provides
    fun provideUpdateWeekStatisticUseCase(statisticRepository: StatisticRepository): UpdateWeekStatisticUseCase{
        return UpdateWeekStatisticUseCase(statisticRepository)
    }

    @Provides
    fun provideFetchWeekStatisticUseCase(statisticRepository: StatisticRepository): FetchWeekStatisticUseCase{
        return FetchWeekStatisticUseCase(statisticRepository)
    }


}