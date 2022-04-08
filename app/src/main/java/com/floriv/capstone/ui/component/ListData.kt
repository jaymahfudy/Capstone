package com.floriv.capstone.ui.component

import android.util.Log
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.floriv.capstone.R
import com.floriv.capstone.core.domain.model.Game

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun ListData(games: List<Game>, navController: NavHostController) {
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
                        navController.navigate("detail/${game.id}")
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
                            /*Box(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(Color.Gray)
                                    .align(Alignment.TopEnd)
                                    .padding(4.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_favorite),
                                    contentDescription = "Icon",
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                )
                            }*/
                        }
                        Text(
                            text = game.name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.black),
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