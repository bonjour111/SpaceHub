package com.lpirro.launches.upcoming.viewmodel

import kotlinx.coroutines.Job

interface UpcomingLaunchesViewModelContract {
    fun getUpcomingLaunches(): Job
    fun refresh()
}
