package com.lpirro.launch_detail.mission.viewmodel

import kotlinx.coroutines.Job

interface LaunchDetailMissionViewModelContract {
    fun getLaunch(id: String): Job
    fun retry()
}
