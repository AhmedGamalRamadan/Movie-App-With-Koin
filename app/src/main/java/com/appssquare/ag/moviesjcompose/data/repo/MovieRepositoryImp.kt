package com.appssquare.ag.moviesjcompose.data.repo

import com.appssquare.ag.moviesjcompose.data.remote.MovieApi
import com.appssquare.ag.moviesjcompose.domain.MovieRepository

class MovieRepositoryImp(
    private val movieApi: MovieApi
) : MovieRepository {

    override suspend fun getMoviesList()=
        movieApi.getMoviesList()

}