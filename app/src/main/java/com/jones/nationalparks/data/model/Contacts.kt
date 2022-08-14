package com.jones.nationalparks.data.model


import com.google.gson.annotations.SerializedName

data class Contacts(
    @SerializedName("emailAddresses")
    var emailAddresses: List<EmailAddresse?>?,
    @SerializedName("phoneNumbers")
    var phoneNumbers: List<PhoneNumber?>?
)