package com.lkb.weatherapp.di.presentation

import com.lkb.weatherapp.model.Repository
import com.lkb.weatherapp.viewmodel.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule{
    @Provides
    fun getViewModelFactory(repository: Repository): ViewModelFactory {
        return ViewModelFactory(repository)
    }

}