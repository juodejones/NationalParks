package com.jones.nationalparks.data.repository

import com.jones.nationalparks.data.model.ParksData
import com.jones.nationalparks.data.utils.Resource
import retrofit2.Response

class ParksRepositoryImpl(private val parksRemoteService: ParksRemoteService) : ParksRepository {
    override suspend fun getParks(): Resource<ParksData> {
        return responseToResource(parksRemoteService.getParks())
    }

    private fun responseToResource(response: Response<ParksData>): Resource<ParksData> {
        if (response.isSuccessful)
            if (response.body() != null)
                return Resource.Success(response.body()!!)

        return Resource.Error("Error occurred while getting response")
    }
}