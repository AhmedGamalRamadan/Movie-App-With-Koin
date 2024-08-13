package com.appssquare.ag.moviesjcompose.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.appssquare.ag.moviesjcompose.presentation.components.MovieItem
import org.koin.androidx.compose.getViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun HomeScreen() {


    val viewModel = getViewModel<MainViewModel>()
    val movieState by viewModel.movieState.collectAsState()


    if (movieState.isEmpty()) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()

        }
    } else {
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            itemsIndexed(movieState) { index, item ->

                MovieItem(movie = item)
                if (index >= movieState.size - 1) {
//                    viewModel.getMovies()
                    LaunchedEffect(key1 = Unit, block = { viewModel.getMovies() })
                }
            }
        }
    }
}