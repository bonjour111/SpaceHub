package com.lpirro.network.models

import com.google.gson.annotations.SerializedName

data class PadRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("url") val url: String,
    @SerializedName("agency_id") val agencyId: Int?,
    @SerializedName("name") val name: String,
    @SerializedName("info_url") val infoUrl: String?,
    @SerializedName("wiki_url") val wikiUrl: String?,
    @SerializedName("map_url") val mapUrl: String?,
    @SerializedName("location") val location: LocationRemote,
    @SerializedName("total_launch_count") val totalLaunchCount: Int?,
    @SerializedName("orbital_launch_attempt_count") val orbitalLaunchAttemptCount: Int?,
    @SerializedName("latitude") val latitude: String?,
    @SerializedName("longitude") val longitude: String?
)
