package com.lpirro.network.models

import com.google.gson.annotations.SerializedName

data class OrbitRemote(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("abbrev") val abbrev: String
)
