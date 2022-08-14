package com.jones.nationalparks.depInj

import android.app.Application
import com.jones.nationalparks.domain.GetParksUseCase
import com.jones.nationalparks.ui.MapsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MapsViewModelFactoryModule {

    @Provides
    @Singleton
    fun provideMapViewModelFactory(
        app: Application,
        getParksUseCase: GetParksUseCase
    ): MapsViewModelFactory {
        return MapsViewModelFactory(app, getParksUseCase)
    }
}