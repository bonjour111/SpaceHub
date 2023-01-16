package com.lpirro.launch_detail.overview.model

import com.google.android.gms.maps.model.LatLng

interface LaunchOverviewItem

data class CountdownHeaderUi(
    val name: String,
    val launchDate: String?,
    val netMillis: Long?
) : LaunchOverviewItem

data class LaunchpadUi(
    val name: String,
    val locationName: String,
    val totalLaunchCount: String,
    val infoUrl: String?,
    val wikiUrl: String?,
    val mapUrl: String?,
) : LaunchOverviewItem

data class WatchLiveUi(
    val youtubeVideoId: String
) : LaunchOverviewItem

data class AgencyUi(
    val name: String,
    val countryCode: String,
    val administrator: String,
    val foundingYear: String,
    val totalLaunchCount: String,
    val logoUrl: String?
) : LaunchOverviewItem

data class LocationUi(
    val name: String,
    val latLng: LatLng
) : LaunchOverviewItem

data class TrajectoryUi(
    val flightClubUrl: String
) : LaunchOverviewItem
