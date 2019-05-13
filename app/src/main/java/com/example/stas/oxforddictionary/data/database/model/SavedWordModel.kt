package com.example.stas.oxforddictionary.data.database.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class SavedWordModel(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        val id: Long? = null,
        @ColumnInfo(name = "value")
        val value: String,
        @ColumnInfo(name = "definition")
        val definition: String)
