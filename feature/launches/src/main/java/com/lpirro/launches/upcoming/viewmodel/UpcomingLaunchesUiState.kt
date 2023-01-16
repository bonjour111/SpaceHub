package com.lpirro.launches.upcoming.viewmodel

import com.lpirro.domain.models.Launch

sealed class UpcomingLaunchesUiState {
    object Loading : UpcomingLaunchesUiState()
    data class Refresh(val isRefreshing: Boolean) : UpcomingLaunchesUiState()
    data class Success(val launches: List<Launch>) : UpcomingLaunchesUiState()
    object Error : UpcomingLaunchesUiState()
}
