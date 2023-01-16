package com.lpirro.launches.past.viewmodel

import kotlinx.coroutines.Job

interface PastLaunchesViewModelContract {
    fun getPastLaunches(): Job
    fun refresh()
}
