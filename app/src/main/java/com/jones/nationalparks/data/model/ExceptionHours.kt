package com.jones.nationalparks.data.model


import com.google.gson.annotations.SerializedName

data class ExceptionHours(
    @SerializedName("friday")
    var friday: String?,
    @SerializedName("monday")
    var monday: String?,
    @SerializedName("saturday")
    var saturday: String?,
    @SerializedName("sunday")
    var sunday: String?,
    @SerializedName("thursday")
    var thursday: String?,
    @SerializedName("tuesday")
    var tuesday: String?,
    @SerializedName("wednesday")
    var wednesday: String?
)