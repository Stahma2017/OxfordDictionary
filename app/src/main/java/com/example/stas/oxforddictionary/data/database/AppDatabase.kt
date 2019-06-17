package com.example.stas.oxforddictionary.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.stas.oxforddictionary.data.database.dao.SavedWordDao
import com.example.stas.oxforddictionary.data.database.dao.ViewedWordDao
import com.example.stas.oxforddictionary.data.database.dao.WeekStatisticDao
import com.example.stas.oxforddictionary.data.database.model.SavedWordModel
import com.example.stas.oxforddictionary.data.database.model.ViewedWordModel
import com.example.stas.oxforddictionary.data.database.model.WeekStatisticModel

@Database(entities = [SavedWordModel::class, ViewedWordModel::class, WeekStatisticModel::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun savedWordDao(): SavedWordDao
    abstract fun viewedWordDao(): ViewedWordDao
    abstract fun weekStatisticDao(): WeekStatisticDao
}