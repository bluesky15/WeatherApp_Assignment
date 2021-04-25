package com.lkb.weatherapp.di.presentation

import android.app.Activity
import android.view.LayoutInflater
import com.lkb.weatherapp.model.Repository
import com.lkb.weatherapp.network.WeatherApiService
import com.lkb.weatherapp.network.forcasts.WeatherUseCase
import com.lkb.weatherapp.view.common.BaseActivity
import com.lkb.weatherapp.view.weather.MyAdapter
import dagger.Module
import dagger.Provides

@Module
class PresentationModule(baseActivity: BaseActivity) {
    private var mActivity = baseActivity

    @Provides
    fun getFragmentManager(): androidx.fragment.app.FragmentManager? {
        return mActivity.supportFragmentManager
    }

    @Provides
    fun getLayoutInflater(): LayoutInflater? {
        return LayoutInflater.from(mActivity)
    }

    @Provides
    fun getActivity(): Activity {
        return mActivity
    }

    @Provides
    fun getForcastUseCase(weatherApiService: WeatherApiService): WeatherUseCase {
        return WeatherUseCase(weatherApiService)
    }


    @Provides
    fun getRepository(mWeatherUseCase: WeatherUseCase): Repository {
        return Repository(mWeatherUseCase)
    }

    @Provides
    fun getAdapter(): MyAdapter {
        return MyAdapter()
    }
}
