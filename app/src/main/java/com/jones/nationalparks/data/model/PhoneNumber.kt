package com.jones.nationalparks.data.model


import com.google.gson.annotations.SerializedName

data class PhoneNumber(
    @SerializedName("description")
    var description: String?,
    @SerializedName("extension")
    var extension: String?,
    @SerializedName("phoneNumber")
    var phoneNumber: String?,
    @SerializedName("type")
    var type: String?
)