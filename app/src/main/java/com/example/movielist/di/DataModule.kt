package com.example.movielist.di

import com.example.movielist.data.api.MoviesApi
import com.example.movielist.data.api.NetworkService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {
    @Singleton
    @Provides
    fun provideNetworkService(): NetworkService {
        return NetworkService
    }

    @Singleton
    @Provides
    fun provideApi(service: NetworkService): MoviesApi {
        return service.retrofit
    }
}