package com.example.movielist.di

import com.example.movielist.data.repository.MovieRepositoryImpl
import com.example.movielist.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface DomainModule {
    @Singleton
    @Binds
    fun bindMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository
}