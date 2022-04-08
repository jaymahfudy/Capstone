package com.floriv.capstone.core.ui

import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.floriv.capstone.core.domain.model.Game
import com.floriv.capstone.core.ui.detail.DetailActivity

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun ListData(
    games: List<Game>
    //navController: NavHostController
) {
    val context = LocalContext.current
    LazyVerticalGrid(
        cells = GridCells.Adaptive(128.dp),
        // content padding
        contentPadding = PaddingValues(
            start = 8.dp,
            top = 8.dp,
            end = 8.dp,
            bottom = 60.dp
        ),
        content = {
            items(items = games) { game ->
                Card(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                    elevation = 8.dp,
                    onClick = {
                        //navController.navigate("detail/${game.id}")
                        val intent = Intent(context, DetailActivity::class.java)
                        intent.putExtra("id", game.id.toString())
                        context.startActivity(intent)
                    }
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .size(128.dp)
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(game.backgroundImage),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(128.dp)
                            )
                        }
                        Text(
                            text = game.name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 6.dp, bottom = 12.dp)
                        )
                    }
                }
            }
        }
    )
}