package com.lkb.weatherapp.network.forcasts

import com.lkb.weatherapp.network.WeatherApiService
import com.lkb.weatherapp.model.data.WeatherResponse
import io.reactivex.Observable

class WeatherUseCase(weatherApiService: WeatherApiService) {
    private val mWeatherApiService = weatherApiService

    fun fetchWeather(place: String, units: String, key:String): Observable<WeatherResponse.WeatherData> {
        return mWeatherApiService.getWeather(place,units,key)
    }


}