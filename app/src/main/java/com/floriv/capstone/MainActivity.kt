package com.floriv.capstone

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.floriv.capstone.favorite.FavoriteActivity
import com.floriv.capstone.home.HomeScreen

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
        topBar = { ActionBar() },
        /*bottomBar = {
            if (navBackStackEntry?.destination?.route != "detail/{id}") {
                BottomNavigation(navController = navController)
            }
        }*/
    ) {
        HomeScreen(navController = navController)
        /*NavigationGraph(
            navController = navController,
        )*/
    }
}

@Composable
fun ActionBar() {
    val context = LocalContext.current
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        elevation = 4.dp,
        title = {
            Text("Gamespedia", textAlign = TextAlign.Center)
        },
        backgroundColor = MaterialTheme.colors.primarySurface,
        navigationIcon = {
            /*IconButton(onClick = {*//* Do Something*//* }) {
                Icon(Icons.Filled.ArrowBack, null)
            }*/
        }, actions = {
            /*IconButton(onClick = {*//* Do Something*//* }) {
                Icon(Icons.Filled.Share, null)
            }*/
            IconButton(onClick = {
                val intent = Intent(context, FavoriteActivity::class.java)
                context.startActivity(intent)
            }) {
                Icon(Icons.Filled.Favorite, null)
            }
        })
}