package com.jones.nationalparks.data.model


import com.google.gson.annotations.SerializedName

data class Addresse(
    @SerializedName("city")
    var city: String?,
    @SerializedName("line1")
    var line1: String?,
    @SerializedName("line2")
    var line2: String?,
    @SerializedName("line3")
    var line3: String?,
    @SerializedName("postalCode")
    var postalCode: String?,
    @SerializedName("stateCode")
    var stateCode: String?,
    @SerializedName("type")
    var type: String?
)