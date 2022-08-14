package com.jones.nationalparks.data.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("activities")
    var activities: List<Activity?>?,
    @SerializedName("addresses")
    var addresses: List<Addresse?>?,
    @SerializedName("contacts")
    var contacts: Contacts?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("designation")
    var designation: String?,
    @SerializedName("directionsInfo")
    var directionsInfo: String?,
    @SerializedName("directionsUrl")
    var directionsUrl: String?,
    @SerializedName("entranceFees")
    var entranceFees: List<EntranceFee?>?,
    @SerializedName("entrancePasses")
    var entrancePasses: List<EntrancePasse?>?,
    @SerializedName("fees")
    var fees: List<Any?>?,
    @SerializedName("fullName")
    var fullName: String?,
    @SerializedName("id")
    var id: String?,
    @SerializedName("images")
    var images: List<Image?>?,
    @SerializedName("latLong")
    var latLong: String?,
    @SerializedName("latitude")
    var latitude: String?,
    @SerializedName("longitude")
    var longitude: String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("operatingHours")
    var operatingHours: List<OperatingHour?>?,
    @SerializedName("parkCode")
    var parkCode: String?,
    @SerializedName("states")
    var states: String?,
    @SerializedName("topics")
    var topics: List<Topic?>?,
    @SerializedName("url")
    var url: String?,
    @SerializedName("weatherInfo")
    var weatherInfo: String?
)