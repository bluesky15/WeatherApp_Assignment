package com.lkb.weatherapp.di.presentation

import com.lkb.weatherapp.view.weather.WeatherActivity
import dagger.Subcomponent

@Subcomponent(modules = [PresentationModule::class, ViewModelModule::class])
interface PresentationComponent{
    fun inject(activity: WeatherActivity)
}