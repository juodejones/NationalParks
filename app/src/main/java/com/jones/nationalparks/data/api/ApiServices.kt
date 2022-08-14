package com.jones.nationalparks.data.api

import com.jones.nationalparks.data.model.ParksData
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {
    @GET("parks?stateCode=?&api_key=xvsszP7gYFobZg7jFkygfMcNQOtfEWsRZcYLdg23")
    suspend fun getParks(): Response<ParksData>
}