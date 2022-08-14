package com.jones.nationalparks.data.model


import com.google.gson.annotations.SerializedName

data class Activity(
    @SerializedName("id")
    var id: String?,
    @SerializedName("name")
    var name: String?
)