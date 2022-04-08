package com.floriv.capstone.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game")
data class GameEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "nameOriginal")
    val nameOriginal: String? = null,
    @ColumnInfo(name = "rating")
    val rating: Double? = null,
    @ColumnInfo(name = "ratingsCount")
    val ratingsCount: Int? = null,
    @ColumnInfo(name = "released")
    val released: String? = null,
    @ColumnInfo(name = "descriptionRaw")
    val descriptionRaw: String? = null,
    @ColumnInfo(name = "backgroundImage")
    val backgroundImage: String? = null,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "description")
    val description: String? = null,
    @ColumnInfo(name = "website")
    val website: String? = null,
    @ColumnInfo(name = "backgroundImageAdditional")
    val backgroundImageAdditional: String? = null,
    @ColumnInfo(name = "isFavorite")
    val isFavorite: Boolean? = null
)
