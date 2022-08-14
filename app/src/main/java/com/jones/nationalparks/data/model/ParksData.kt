package com.jones.nationalparks.data.model


import com.google.gson.annotations.SerializedName

data class ParksData(
    @SerializedName("data")
    var `data`: List<Data?>?,
    @SerializedName("limit")
    var limit: String?,
    @SerializedName("start")
    var start: String?,
    @SerializedName("total")
    var total: String?
)