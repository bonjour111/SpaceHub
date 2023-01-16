package com.lpirro.launch_detail.tabs.viewmodel

import kotlinx.coroutines.Job

interface LaunchDetailViewModelContract {
    fun getLaunch(id: String): Job
    fun retry()
}
