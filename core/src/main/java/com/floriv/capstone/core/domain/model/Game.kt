package com.floriv.capstone.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    var id: Int,
    var nameOriginal: String? = null,
    var rating: Double? = null,
    var ratingsCount: Int? = null,
    var released: String? = null,
    var descriptionRaw: String? = null,
    var backgroundImage: String? = null,
    var name: String,
    var description: String? = null,
    var website: String? = null,
    var backgroundImageAdditional: String? = null,
    var isFavorite: Boolean? = null
): Parcelable