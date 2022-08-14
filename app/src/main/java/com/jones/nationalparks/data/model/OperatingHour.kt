package com.jones.nationalparks.data.model


import com.google.gson.annotations.SerializedName

data class OperatingHour(
    @SerializedName("description")
    var description: String?,
    @SerializedName("exceptions")
    var exceptions: List<Exception?>?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("standardHours")
    var standardHours: StandardHours?
)