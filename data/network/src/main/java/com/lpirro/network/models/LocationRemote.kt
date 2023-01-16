package com.lpirro.network.models

import com.google.gson.annotations.SerializedName

data class LocationRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("url") val url: String,
    @SerializedName("name") val name: String,
    @SerializedName("total_launch_count") val totalLaunchCount: Int?,
    @SerializedName("total_landing_count") val totalLandingCount: Int?
)
