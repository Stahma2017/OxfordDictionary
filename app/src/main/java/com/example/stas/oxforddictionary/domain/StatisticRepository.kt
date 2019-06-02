package com.example.stas.oxforddictionary.domain

import com.example.stas.oxforddictionary.data.database.model.WeekStatisticModel
import io.reactivex.Completable
import io.reactivex.Flowable

interface StatisticRepository {
    fun updateStatistic(list: List<WeekStatisticModel>): Completable
    fun fetchStatistic(): Flowable<List<WeekStatisticModel>>
}