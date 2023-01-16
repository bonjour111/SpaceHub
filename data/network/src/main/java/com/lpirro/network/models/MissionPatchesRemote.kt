package com.lpirro.network.models

import com.google.gson.annotations.SerializedName

data class MissionPatchesRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("image_url") val imageUrl: String
)
