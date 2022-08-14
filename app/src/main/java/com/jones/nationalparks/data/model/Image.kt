package com.jones.nationalparks.data.model


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("altText")
    var altText: String?,
    @SerializedName("caption")
    var caption: String?,
    @SerializedName("credit")
    var credit: String?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("url")
    var url: String?
)