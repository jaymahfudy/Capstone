package com.floriv.capstone.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.floriv.capstone.core.ui.ListData
import org.koin.androidx.compose.getViewModel


@Composable
fun HomeScreen() {
    val viewModel = getViewModel<HomeViewModel>()
    viewModel.getAllGames()
    val viewState by viewModel.state.collectAsState()
    viewState.data?.let {
        ListData(games = it)
    }
}

