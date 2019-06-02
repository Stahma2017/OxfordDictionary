package com.example.stas.oxforddictionary.data.repository

import com.example.stas.oxforddictionary.data.database.dao.WeekStatisticDao
import com.example.stas.oxforddictionary.data.database.model.WeekStatisticModel
import com.example.stas.oxforddictionary.domain.StatisticRepository
import io.reactivex.Completable
import io.reactivex.Flowable

class StatisticRepositoryImp(private val weekStatisticDao: WeekStatisticDao) : StatisticRepository {

    override fun updateStatistic(list: List<WeekStatisticModel>): Completable = Completable.fromAction {
        weekStatisticDao.updateStatistic(list)
    }

    override fun fetchStatistic(): Flowable<List<WeekStatisticModel>> {
        return weekStatisticDao.getAll()
    }
}