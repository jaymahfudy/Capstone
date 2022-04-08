package com.floriv.capstone.detail

import android.util.TypedValue
import android.widget.TextView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import coil.compose.rememberAsyncImagePainter
import com.floriv.capstone.R
import org.koin.androidx.compose.getViewModel

@Composable
fun DetailScreen(id: String?) {
    val viewModel = getViewModel<DetailViewModel>()
    viewModel.getGame(id!!)
    val viewState by viewModel.state.collectAsState()
    viewState.data?.let {
        Box(Modifier.fillMaxSize()) {
            Column {
                Image(
                    painter = rememberAsyncImagePainter(it.backgroundImage),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp)
                ) {
                    Html(text = it.description!!)
                }
            }
            var favIcon by remember {
                mutableStateOf(it.isFavorite)
            }

            FloatingActionButton(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(12.dp),
                onClick = {
                    favIcon = !favIcon!!
                    val game = it
                    game.isFavorite = favIcon
                    viewModel.updateGame(game)
                }
            ) {
                Image(
                    painter = if (favIcon == true) {
                        painterResource(id = R.drawable.ic_favorite_red)
                    } else {
                        painterResource(id = R.drawable.ic_favorite_white)
                    },
                    contentDescription = "Icon",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .clip(CircleShape)
                )
            }
        }
    }
}

@Composable
fun Html(text: String) {
    AndroidView(factory = { context ->
        TextView(context).apply {
            setTextSize(
                TypedValue.COMPLEX_UNIT_PX,
                context.resources.getDimension(R.dimen.text_medium)
            )
            setText(
                HtmlCompat.fromHtml(
                    text,
                    HtmlCompat.FROM_HTML_MODE_LEGACY
                )
            )
        }
    })
}