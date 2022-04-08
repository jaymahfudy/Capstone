package com.floriv.capstone.detail

import com.floriv.capstone.core.domain.model.Game

data class DetailUiState(
    var isLoading: Boolean = false,
    var message: String? = "",
    var data: Game? = null
)