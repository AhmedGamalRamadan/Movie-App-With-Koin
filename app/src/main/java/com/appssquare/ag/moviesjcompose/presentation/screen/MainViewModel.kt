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
    private  val _movieListStat = MutableStateFlow<List<Movie>>(emptyList())

    val movieListStat =_movieListStat.asStateFlow()

    private fun getMovies(){
        viewModelScope.launch {
            try {
                val result =movieRepository.getMoviesList()
                _movieListStat.value =result.results

            }catch (e:Exception){
                Log.d("MainViewModel",e.message.toString())
            }

        }
    }
}