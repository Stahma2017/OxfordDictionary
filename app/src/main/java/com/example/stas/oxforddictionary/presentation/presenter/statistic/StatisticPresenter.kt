package com.example.stas.oxforddictionary.presentation.presenter.statistic

import com.example.stas.oxforddictionary.domain.usecase.statistic.FetchWeekStatisticUseCase
import com.example.stas.oxforddictionary.presentation.view.base.ErrorHandler
import com.example.stas.oxforddictionary.presentation.view.statistic.StatisticContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class StatisticPresenter(private val errorHandler: ErrorHandler,
                         private val compositeDisposable: CompositeDisposable,
                         private val fetchWeekStatisticUseCase: FetchWeekStatisticUseCase) : StatisticContract.Presenter{

    private var view: StatisticContract.View? = null

    override fun detachView() {
        view = null
        compositeDisposable.dispose()
        errorHandler.detachView()
    }

    override fun attachView(view: StatisticContract.View) {
        this.view = view
        errorHandler.attachView(view)
    }

    override fun fetchStatistic() {
       val fetchStat = fetchWeekStatisticUseCase.fetchStatistic()
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe({
                   view?.showStatistic(it)
               }, { error -> errorHandler.proceed(error) })
        compositeDisposable.add(fetchStat)
    }
}