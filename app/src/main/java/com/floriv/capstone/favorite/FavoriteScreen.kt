package com.floriv.capstone.favorite

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.floriv.capstone.ui.component.ListData

@Composable
fun FavoriteScreen(viewModel: FavoriteViewModel, navController: NavHostController) {
    viewModel.getFavoriteGames()
    val viewState by viewModel.state.collectAsState()
    viewState.data?.let {
        ListData(games = it, navController = navController)
    }
}