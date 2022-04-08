package com.floriv.capstone.core.ui.component

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController,
        startDestination = BottomNavItem.Home.screen_route,
    ) {
        composable(BottomNavItem.Home.screen_route) {
            //val viewModel = getViewModel<HomeViewModel>()
            //HomeScreen(navController)
        }
        composable(BottomNavItem.Favorite.screen_route) {
            //val viewModel = getViewModel<FavoriteViewModel>()
            //FavoriteScreen()
        }
        composable("detail/{id}") { backStackEntry ->
            //val viewModel = getViewModel<DetailViewModel>()
            val id = backStackEntry.arguments?.getString("id")
            //DetailScreen(id)
        }
    }
}