package com.lkb.weatherapp

import android.app.Application
import com.lkb.weatherapp.di.application.ApplicationComponent
import com.lkb.weatherapp.di.application.DaggerApplicationComponent


class MyApplication : Application() {
    lateinit var mApplicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        mApplicationComponent = DaggerApplicationComponent.builder().build()
    }

    fun getApplicationComponent(): ApplicationComponent {
        return mApplicationComponent
    }
}