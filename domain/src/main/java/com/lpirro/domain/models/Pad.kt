package com.lpirro.domain.models

data class Pad(
    val id: Int,
    val url: String,
    val agencyId: Int?,
    val name: String,
    val infoUrl: String?,
    val wikiUrl: String?,
    val mapUrl: String?,
    val location: Location,
    val totalLaunchCount: Int?,
    val orbitalLaunchAttemptCount: Int?,
    val mapPosition: MapPosition?
)
