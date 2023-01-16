package com.lpirro.domain.models

data class Launch(
    val id: String,
    val name: String,
    val image: String?,
    val launchServiceProvider: Agency,
    val missionPatches: List<MissionPatches>?,
    val mission: Mission?,
    val pad: Pad,
    val net: String?,
    val windowStart: String?,
    val windowEnd: String?,
    val netMillis: Long?,
    val status: Status,
    val youtubeVideoId: String?,
    val infoUrl: String?,
    val flightClubUrl: String?,
    val updates: List<Update>?
)
