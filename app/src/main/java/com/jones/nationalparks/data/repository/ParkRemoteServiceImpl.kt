package com.jones.nationalparks.data.repository

import com.jones.nationalparks.data.api.ApiServices
import com.jones.nationalparks.data.model.ParksData
import retrofit2.Response

class ParkRemoteServiceImpl(private val apiServices: ApiServices): ParksRemoteService {
    override suspend fun getParks(): Response<ParksData> {
        return apiServices.getParks()
    }
}