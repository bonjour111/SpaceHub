package com.lpirro.network.models

import com.google.gson.annotations.SerializedName

data class LaunchRemote(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String?,
    @SerializedName("launch_service_provider") val launchServiceProvider: AgencyRemote,
    @SerializedName("mission_patches") val missionPatches: List<MissionPatchesRemote>?,
    @SerializedName("pad") val pad: PadRemote,
    @SerializedName("mission") val mission: MissionRemote?,
    @SerializedName("net") val net: String?,
    @SerializedName("window_start") val windowStart: String?,
    @SerializedName("window_end") val windowEnd: String?,
    @SerializedName("status") val status: StatusRemote,
    @SerializedName("vidURLs") val videoUrls: List<Urls>,
    @SerializedName("infoURLs") val infoURLs: List<Urls>?,
    @SerializedName("flightclub_url") val flightClubUrl: String?,
    @SerializedName("updates") val updates: List<UpdateRemote>?,
)
