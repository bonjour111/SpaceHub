package com.lpirro.launch_detail.overview.viewmodel

import kotlinx.coroutines.Job

interface LaunchDetailOverviewViewModelContract {
    fun getLaunch(id: String): Job
    fun retry()
    fun openLaunchTrajectory(url: String)
    fun openGoogleMaps(url: String)
    fun openChromeCustomTab(url: String)
    fun openYouTubeInFullScreen(videoId: String)
    fun addLaunchToCalendar(launchName: String, launchDateMillis: Long)
}
