package com.appssquare.ag.moviesjcompose.presentation.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appssquare.ag.moviesjcompose.domain.MovieRepository
import com.appssquare.ag.moviesjcompose.model.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val movieRepository: MovieRepository
) : ViewModel() {

    init {
        getMovies()
    }

    private val _movieState = MutableStateFlow<List<Movie>>(emptyList())
    val movieState = _movieState.asStateFlow()

    private var pageNumber: Int = 1

    fun getMovies() {
        if (pageNumber == 0) pageNumber = 1 // Ensuring it never starts at 0

        viewModelScope.launch {
            try {
                Log.d("MainViewModel", "Requesting movies for page: $pageNumber")
                val result = movieRepository.getMoviesList(page = pageNumber).results

                val movies = if (pageNumber == 1) result else _movieState.value + result

                _movieState.value = movies
                pageNumber++

            } catch (e: Exception) {
                Log.d("MainViewModel", e.message.toString())
            }
        }
    }
}