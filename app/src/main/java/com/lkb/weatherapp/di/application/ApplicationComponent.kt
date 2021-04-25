package com.lkb.weatherapp.di.application

import com.lkb.weatherapp.di.presentation.PresentationComponent
import com.lkb.weatherapp.di.presentation.PresentationModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface ApplicationComponent {
fun newPresentationComponent(presentationModule: PresentationModule): PresentationComponent
}