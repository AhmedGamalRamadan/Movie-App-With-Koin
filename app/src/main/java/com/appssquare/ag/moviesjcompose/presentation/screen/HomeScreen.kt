package com.appssquare.ag.moviesjcompose.presentation.screen

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.appssquare.ag.moviesjcompose.presentation.components.MovieItem
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen() {


    val viewModel = getViewModel<MainViewModel>()
    val movieList by viewModel.movieListStat.collectAsState()


    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ){
        items(movieList){movie ->
            MovieItem(movie = movie)
        }
    }
}