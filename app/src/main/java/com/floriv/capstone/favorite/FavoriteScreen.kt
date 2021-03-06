package com.floriv.capstone.favorite

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.floriv.capstone.core.ListData
import org.koin.androidx.compose.getViewModel

@Composable
fun FavoriteScreen(navController: NavHostController) {
    val viewModel = getViewModel<FavoriteViewModel>()
    viewModel.getFavoriteGames()
    val viewState by viewModel.state.collectAsState()
    viewState.data?.let {
        ListData(games = it, navController = navController)
    }
}