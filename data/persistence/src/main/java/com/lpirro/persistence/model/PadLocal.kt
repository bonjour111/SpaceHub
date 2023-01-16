package com.lpirro.persistence.model

data class PadLocal(
    val id: Int,
    val url: String,
    val agencyId: Int?,
    val name: String,
    val infoUrl: String?,
    val wikiUrl: String?,
    val mapUrl: String?,
    val location: LocationLocal,
    val totalLaunchCount: Int?,
    val orbitalLaunchAttemptCount: Int?,
    val latitude: String?,
    val longitude: String?
)
