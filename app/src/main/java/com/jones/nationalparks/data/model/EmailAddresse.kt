package com.jones.nationalparks.data.model


import com.google.gson.annotations.SerializedName

data class EmailAddresse(
    @SerializedName("description")
    var description: String?,
    @SerializedName("emailAddress")
    var emailAddress: String?
)