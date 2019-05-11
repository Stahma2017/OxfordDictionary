package com.example.stas.oxforddictionary.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.stas.oxforddictionary.data.database.model.SavedWordModel

@Dao
interface SavedWordDao {

    @Query("SELECT * FROM SavedWordModel")
    fun getAll(): List<SavedWordModel>

    @Insert
    fun insert(word: SavedWordModel)
}