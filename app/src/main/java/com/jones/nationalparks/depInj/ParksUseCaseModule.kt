package com.jones.nationalparks.depInj

import com.jones.nationalparks.data.repository.ParksRepository
import com.jones.nationalparks.domain.GetParksUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ParksUseCaseModule {

    @Provides
    @Singleton
    fun providesParksUseCase(parksRepository: ParksRepository): GetParksUseCase{
        return GetParksUseCase(parksRepository)
    }
}