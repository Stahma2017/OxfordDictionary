package com.example.stas.oxforddictionary.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.stas.oxforddictionary.data.database.model.SavedWordModel
import io.reactivex.Flowable

@Dao
interface SavedWordDao {

    @Query("SELECT * FROM savedWordModel")
    fun getAll(): Flowable<List<SavedWordModel>>

    @Insert
    fun insert(word: SavedWordModel)
}