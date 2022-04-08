package com.floriv.capstone.ui.component

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.floriv.capstone.detail.DetailScreen
import com.floriv.capstone.favorite.FavoriteScreen
import com.floriv.capstone.home.HomeScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController,
        startDestination = BottomNavItem.Home.screen_route,
    ) {
        composable(BottomNavItem.Home.screen_route) {
            //val viewModel = getViewModel<HomeViewModel>()
            HomeScreen(navController)
        }
        composable(BottomNavItem.Favorite.screen_route) {
            //val viewModel = getViewModel<FavoriteViewModel>()
            FavoriteScreen(navController)
        }
        composable("detail/{id}") { backStackEntry ->
            //val viewModel = getViewModel<DetailViewModel>()
            val id = backStackEntry.arguments?.getString("id")
            DetailScreen(id)
        }
    }
}