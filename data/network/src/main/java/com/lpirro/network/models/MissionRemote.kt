package com.lpirro.network.models

import com.google.gson.annotations.SerializedName

data class MissionRemote(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("type") val type: String,
    @SerializedName("orbit") val orbit: OrbitRemote?
)
