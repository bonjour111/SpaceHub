package com.lpirro.launch_detail.overview.viewmodel

import com.lpirro.launch_detail.overview.model.LaunchOverviewItem

sealed class LaunchDetailOverviewUiState {
    object Loading : LaunchDetailOverviewUiState()
    data class Success(val launchOverview: List<LaunchOverviewItem>) : LaunchDetailOverviewUiState()
    object Error : LaunchDetailOverviewUiState()
}
