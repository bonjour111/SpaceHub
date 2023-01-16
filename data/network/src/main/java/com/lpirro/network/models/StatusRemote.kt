package com.lpirro.network.models

import com.google.gson.annotations.SerializedName

data class StatusRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("abbrev") val abbrev: String,
    @SerializedName("description") val description: String
)
