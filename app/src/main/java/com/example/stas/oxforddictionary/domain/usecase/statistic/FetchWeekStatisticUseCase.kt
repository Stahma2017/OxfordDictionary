package com.example.stas.oxforddictionary.domain.usecase.statistic

import com.example.stas.oxforddictionary.data.database.model.WeekStatisticModel
import com.example.stas.oxforddictionary.domain.StatisticRepository
import io.reactivex.Flowable

class FetchWeekStatisticUseCase(private val statisticRepository: StatisticRepository) {

    fun fetchStatistic() : Flowable<List<WeekStatisticModel>> =
            statisticRepository.fetchStatistic()
}