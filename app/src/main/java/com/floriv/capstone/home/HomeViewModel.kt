package com.floriv.capstone.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.floriv.capstone.core.data.Resource
import com.floriv.capstone.core.domain.usecase.GameUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val gameUseCase: GameUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeUiState())

    val state: StateFlow<HomeUiState>
        get() = _state

    fun getAllGames() = viewModelScope.launch {
        gameUseCase.getAllGames().collect {
            when (it) {
                is Resource.Loading -> {
                    _state.value = HomeUiState(isLoading = true)
                }
                is Resource.Success -> {
                    val data = it.data?.toList()
                    _state.value = HomeUiState(data = data!!)
                }
                is Resource.Error -> {
                    _state.value = HomeUiState(message = it.message)
                }
                else -> {
                    _state.value = HomeUiState(isLoading = false)
                }
            }
        }
    }

    val games = gameUseCase.getAllGames().asLiveData()
}