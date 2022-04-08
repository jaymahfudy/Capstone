package com.floriv.capstone.home

import com.floriv.capstone.core.domain.model.Game

data class HomeUiState(
    var isLoading: Boolean = false,
    var message: String? = "",
    var data: List<Game>? = null
)