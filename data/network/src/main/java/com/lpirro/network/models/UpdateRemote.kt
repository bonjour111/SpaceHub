package com.lpirro.network.models

import com.google.gson.annotations.SerializedName

data class UpdateRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("profile_image") val profileImage: String?,
    @SerializedName("comment") val comment: String?,
    @SerializedName("created_on") val createdOn: String?,
    @SerializedName("created_by") val createdBy: String?,
    @SerializedName("info_url") val infoUrl: String?
)
