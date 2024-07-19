package com.appssquare.ag.moviesjcompose.data.remote

import com.appssquare.ag.moviesjcompose.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    suspend fun getMoviesList(
        @Query("language") language:String ="en-US",
        @Query("page") page: Int=1 ,
        @Query("api_key") apiKey: String = API_KEY
    ): MovieResponse

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"
        const val API_KEY = "5e4ca5a6a3889c5074d8caae0803f4d3"
    }

}
