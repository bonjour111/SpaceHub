package com.lpirro.network.models

import com.google.gson.annotations.SerializedName

data class AgencyRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("url") val url: String,
    @SerializedName("name") val name: String,
    @SerializedName("country_code") val countryCode: String,
    @SerializedName("administrator") val administrator: String?,
    @SerializedName("founding_year") val foundingYear: String?,
    @SerializedName("total_launch_count") val totalLaunchCount: Int?,
    @SerializedName("logo_url") val logoUrl: String?
)
