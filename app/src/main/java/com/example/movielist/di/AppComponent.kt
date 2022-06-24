package com.example.movielist.di

import com.example.movielist.presentation.activities.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class, DomainModule::class])
interface AppComponent {
    fun injectMainActivity(mainActivity: MainActivity)
}