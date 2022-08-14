package com.jones.nationalparks.data.model


import com.google.gson.annotations.SerializedName

data class Topic(
    @SerializedName("id")
    var id: String?,
    @SerializedName("name")
    var name: String?
)