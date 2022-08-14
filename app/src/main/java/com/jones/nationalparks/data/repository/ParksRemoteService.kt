package com.jones.nationalparks.data.repository

import com.jones.nationalparks.data.model.ParksData
import retrofit2.Response

interface ParksRemoteService {
    suspend fun getParks(): Response<ParksData>
}