package com.jones.nationalparks.depInj

import com.jones.nationalparks.data.repository.ParksRemoteService
import com.jones.nationalparks.data.repository.ParksRepository
import com.jones.nationalparks.data.repository.ParksRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryImplModule {

    @Provides
    @Singleton
    fun provideRepositoryImpl(parksRemoteService: ParksRemoteService): ParksRepository {
        return ParksRepositoryImpl(parksRemoteService)
    }
}