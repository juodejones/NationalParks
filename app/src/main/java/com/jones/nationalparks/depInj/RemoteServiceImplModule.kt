package com.jones.nationalparks.depInj

import com.jones.nationalparks.data.api.ApiServices
import com.jones.nationalparks.data.repository.ParkRemoteServiceImpl
import com.jones.nationalparks.data.repository.ParksRemoteService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteServiceImplModule {

    @Provides
    @Singleton
    fun provideRemoteServiceImpl(apiServices: ApiServices): ParksRemoteService {
        return ParkRemoteServiceImpl(apiServices)
    }
}