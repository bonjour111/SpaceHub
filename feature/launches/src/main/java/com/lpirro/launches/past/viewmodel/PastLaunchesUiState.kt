package com.lpirro.launches.past.viewmodel

import com.lpirro.domain.models.Launch

sealed class PastLaunchesUiState {
    object Loading : PastLaunchesUiState()
    data class Refresh(val isRefreshing: Boolean) : PastLaunchesUiState()
    data class Success(val launches: List<Launch>) : PastLaunchesUiState()
    object Error : PastLaunchesUiState()
}
