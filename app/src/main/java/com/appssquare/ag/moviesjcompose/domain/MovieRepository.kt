package com.appssquare.ag.moviesjcompose.domain

import com.appssquare.ag.moviesjcompose.model.MovieResponse

interface MovieRepository {

    suspend fun getMoviesList(): MovieResponse
}