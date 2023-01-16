package com.lpirro.launch_detail.overview.viewmodel

sealed class LaunchDetailOverviewEvent {
    data class OpenLaunchTrajectory(val url: String) : LaunchDetailOverviewEvent()
    data class OpenChromeCustomTab(val url: String) : LaunchDetailOverviewEvent()
    data class OpenGoogleMaps(val url: String) : LaunchDetailOverviewEvent()
    data class OpenYouTubeInFullScreen(val videoId: String) : LaunchDetailOverviewEvent()
    data class AddToCalendar(val launchName: String, val launchDateMillis: Long) : LaunchDetailOverviewEvent()
}
