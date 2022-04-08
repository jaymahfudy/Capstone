package com.floriv.capstone.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.floriv.capstone.core.data.Resource
import com.floriv.capstone.core.domain.model.Game
import com.floriv.capstone.core.domain.usecase.GameUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val gameUseCase: GameUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(DetailUiState())

    val state: StateFlow<DetailUiState>
        get() = _state

    fun getGame(id: String) = viewModelScope.launch {
        when (val game = gameUseCase.getGame(id)) {
            is Resource.Loading -> {
                _state.value = DetailUiState(isLoading = true)
            }
            is Resource.Success -> {
                val data = game.data
                _state.value = DetailUiState(data = data!!)
            }
            is Resource.Error -> {
                _state.value = DetailUiState(message = game.message)
            }
            else -> {
                _state.value = DetailUiState(isLoading = false)
            }
        }
    }

    fun updateGame(game: Game) = gameUseCase.updateGame(game)
}