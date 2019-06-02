package com.example.stas.oxforddictionary.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.stas.oxforddictionary.data.database.model.WeekStatisticModel
import io.reactivex.Flowable

@Dao
interface WeekStatisticDao {

    @Query("SELECT * FROM WeekStatisticModel")
    fun getAll(): Flowable<List<WeekStatisticModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateStatistic(words: List<WeekStatisticModel>)
}