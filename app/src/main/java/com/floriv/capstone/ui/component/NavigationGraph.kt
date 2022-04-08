package com.floriv.capstone.ui.component

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.floriv.capstone.detail.DetailScreen
import com.floriv.capstone.detail.DetailViewModel
import com.floriv.capstone.favorite.FavoriteScreen
import com.floriv.capstone.favorite.FavoriteViewModel
import com.floriv.capstone.home.HomeScreen
import com.floriv.capstone.home.HomeViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController,
        startDestination = BottomNavItem.Home.screen_route,
    ) {
        composable(BottomNavItem.Home.screen_route) {
            val viewModel = getViewModel<HomeViewModel>()
            HomeScreen(viewModel, navController)
        }
        composable(BottomNavItem.Favorite.screen_route) {
            val viewModel = getViewModel<FavoriteViewModel>()
            FavoriteScreen(viewModel, navController)
        }
        composable("detail/{id}") { backStackEntry ->
            val viewModel = getViewModel<DetailViewModel>()
            val id = backStackEntry.arguments?.getString("id")
            DetailScreen(viewModel, id)
        }
    }
}