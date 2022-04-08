package com.floriv.capstone

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.floriv.capstone.home.HomeScreen
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainScreenView() }
    }

}

@Composable
fun MainScreenView() {
    Scaffold(
        topBar = { ActionBar() },
    ) {
        HomeScreen()
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
                try {
                    val splitInstallManager = SplitInstallManagerFactory.create(context)
                    val moduleFavorite = "favorite"
                    if (splitInstallManager.installedModules.contains(moduleFavorite)) {
                        val intent = Intent(
                            context,
                            Class.forName("com.floriv.capstone.favorite.FavoriteActivity")
                        )
                        context.startActivity(intent)
                        Toast.makeText(context, "Open module", Toast.LENGTH_SHORT).show()
                    } else {
                        val request = SplitInstallRequest.newBuilder()
                            .addModule(moduleFavorite)
                            .build()
                        splitInstallManager.startInstall(request)
                            .addOnSuccessListener {
                                Toast.makeText(
                                    context,
                                    "Success installing module",
                                    Toast.LENGTH_SHORT
                                ).show()
                                val intent = Intent(
                                    context,
                                    Class.forName("com.floriv.capstone.favorite.FavoriteActivity")
                                )
                                context.startActivity(intent)
                            }
                            .addOnFailureListener {
                                Toast.makeText(
                                    context,
                                    "Error installing module",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                    }
                } catch (e: Exception) {
                    Toast.makeText(context, "Module not found", Toast.LENGTH_SHORT).show()
                }
            }) {
                Icon(Icons.Filled.Favorite, null)
            }
        })
}