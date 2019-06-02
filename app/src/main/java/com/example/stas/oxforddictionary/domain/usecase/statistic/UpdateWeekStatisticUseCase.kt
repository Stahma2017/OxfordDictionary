package com.example.stas.oxforddictionary.domain.usecase.statistic

import com.example.stas.oxforddictionary.data.database.model.WeekStatisticModel
import com.example.stas.oxforddictionary.domain.StatisticRepository
import io.reactivex.Completable

class UpdateWeekStatisticUseCase(private val statisticRepository: StatisticRepository) {
    fun updateStatistic(list: List<WeekStatisticModel>): Completable =
            statisticRepository.updateStatistic(list)
}