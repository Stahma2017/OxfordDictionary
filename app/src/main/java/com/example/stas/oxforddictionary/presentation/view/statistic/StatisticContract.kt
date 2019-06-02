package com.example.stas.oxforddictionary.presentation.view.statistic

import com.example.stas.oxforddictionary.data.database.model.WeekStatisticModel
import com.example.stas.oxforddictionary.presentation.view.base.CanShowError

interface StatisticContract {
    interface View: CanShowError {
       fun showStatistic(list: List<WeekStatisticModel>)
    }

    interface Presenter{
        fun detachView()
        fun attachView(view: View)
        fun fetchStatistic()
    }
}