package com.appssquare.ag.moviesjcompose.koin

import com.appssquare.ag.moviesjcompose.data.remote.MovieApi
import com.appssquare.ag.moviesjcompose.data.repo.MovieRepositoryImp
import com.appssquare.ag.moviesjcompose.domain.MovieRepository
import com.appssquare.ag.moviesjcompose.presentation.screen.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {

    single {

        Retrofit.Builder()
            .baseUrl(MovieApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }

    single<MovieRepository> {

        MovieRepositoryImp(get())
    }


    viewModel {

        MainViewModel(get())
    }


}