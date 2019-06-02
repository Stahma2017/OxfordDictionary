package com.example.stas.oxforddictionary.data.database.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class WeekStatisticModel(@PrimaryKey
                              @ColumnInfo(name = "id")
                              val id: Int? = null,
                              @ColumnInfo(name = "count")
                              var count: Int)