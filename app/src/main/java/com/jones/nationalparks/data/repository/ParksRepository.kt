package com.jones.nationalparks.data.repository

import com.jones.nationalparks.data.model.ParksData
import com.jones.nationalparks.data.utils.Resource

interface ParksRepository {
    suspend fun getParks(): Resource<ParksData>
}