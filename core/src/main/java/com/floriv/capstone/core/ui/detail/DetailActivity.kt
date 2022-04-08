package com.floriv.capstone.core.ui.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.floriv.capstone.core.ui.theme.CapstoneTheme

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = intent.getStringExtra("id")
        setContent {
            CapstoneTheme {
                DetailScreen(id = id)
            }
        }
    }
}