package com.floriv.capstone.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.floriv.capstone.ui.component.ListData


@Composable
fun HomeScreen(homeViewModel: HomeViewModel, navController: NavHostController) {
    homeViewModel.getAllGames()
    val viewState by homeViewModel.state.collectAsState()
    viewState.data?.let {
        ListData(games = it, navController)
    }
}

