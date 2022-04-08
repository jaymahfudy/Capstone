package com.floriv.capstone.favorite

import com.floriv.capstone.core.domain.model.Game

data class FavoriteUiState(
    var isLoading: Boolean = false,
    var message: String? = "",
    var data: List<Game>? = null
)