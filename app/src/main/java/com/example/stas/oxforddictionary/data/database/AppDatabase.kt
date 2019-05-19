package com.example.stas.oxforddictionary.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.stas.oxforddictionary.data.database.dao.SavedWordDao
import com.example.stas.oxforddictionary.data.database.dao.ViewedWordDao
import com.example.stas.oxforddictionary.data.database.model.SavedWordModel
import com.example.stas.oxforddictionary.data.database.model.ViewedWordModel

@Database(entities = [SavedWordModel::class, ViewedWordModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun savedWordDao(): SavedWordDao
    abstract fun viewedWordDao(): ViewedWordDao
}