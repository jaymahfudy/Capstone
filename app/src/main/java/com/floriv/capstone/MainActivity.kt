package com.floriv.capstone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.floriv.capstone.ui.component.BottomNavigation
import com.floriv.capstone.ui.component.NavigationGraph

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainScreenView() }
    }

}

@Composable
fun MainScreenView() {
    val navController = rememberNavController()
    // Subscribe to navBackStackEntry, required to get current route
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    Scaffold(
        bottomBar = {
            if (navBackStackEntry?.destination?.route != "detail/{id}") {
                BottomNavigation(navController = navController)
            }
        }
    ) {
        NavigationGraph(
            navController = navController,
        )
    }
}