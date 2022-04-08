package com.floriv.capstone.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.floriv.capstone.core.domain.usecase.GameUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val gameUseCase: GameUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(FavoriteUiState())

    val state: StateFlow<FavoriteUiState>
        get() = _state

    fun getFavoriteGames() = viewModelScope.launch {
        gameUseCase.getFavoriteGames().collect {
            _state.value = FavoriteUiState(data = it)
        }
    }

    val games = gameUseCase.getFavoriteGames().asLiveData()
}