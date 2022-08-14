package com.jones.nationalparks.data.model


import com.google.gson.annotations.SerializedName

data class EntrancePasse(
    @SerializedName("cost")
    var cost: String?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("title")
    var title: String?
)