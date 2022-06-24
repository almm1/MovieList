package com.example.movielist

import android.app.Application
import com.example.movielist.di.AppComponent
import com.example.movielist.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}