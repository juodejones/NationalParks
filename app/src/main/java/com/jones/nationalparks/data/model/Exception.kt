package com.jones.nationalparks.data.model


import com.google.gson.annotations.SerializedName

data class Exception(
    @SerializedName("endDate")
    var endDate: String?,
    @SerializedName("exceptionHours")
    var exceptionHours: ExceptionHours?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("startDate")
    var startDate: String?
)