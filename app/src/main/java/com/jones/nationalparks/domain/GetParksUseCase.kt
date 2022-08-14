package com.jones.nationalparks.domain

import com.jones.nationalparks.data.model.ParksData
import com.jones.nationalparks.data.repository.ParksRepository
import com.jones.nationalparks.data.utils.Resource

class GetParksUseCase(private val parksRepository: ParksRepository) {
    suspend fun getParks(): Resource<ParksData> {
        return parksRepository.getParks()
    }
}