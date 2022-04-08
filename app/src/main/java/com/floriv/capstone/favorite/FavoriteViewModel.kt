package com.floriv.capstone.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.floriv.capstone.core.data.Resource
import com.floriv.capstone.core.domain.usecase.GameUseCase
import com.floriv.capstone.home.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val gameUseCase: GameUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeUiState())

    val state: StateFlow<HomeUiState>
        get() = _state

    fun getFavoriteGames() = viewModelScope.launch {
        gameUseCase.getFavoriteGames().collect {
            _state.value = HomeUiState(data = it)
        }
    }

    val games = gameUseCase.getFavoriteGames().asLiveData()
}