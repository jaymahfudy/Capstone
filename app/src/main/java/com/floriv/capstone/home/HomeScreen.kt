package com.floriv.capstone.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.floriv.capstone.core.ListData
import org.koin.androidx.compose.getViewModel


@Composable
fun HomeScreen(navController: NavHostController) {
    val viewModel = getViewModel<HomeViewModel>()
    viewModel.getAllGames()
    val viewState by viewModel.state.collectAsState()
    viewState.data?.let {
        ListData(games = it, navController)
    }
}

