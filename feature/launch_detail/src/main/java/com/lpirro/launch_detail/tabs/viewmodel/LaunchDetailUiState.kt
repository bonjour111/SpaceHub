package com.lpirro.launch_detail.tabs.viewmodel

import com.lpirro.domain.models.Launch

sealed class LaunchDetailUiState {
    object Loading : LaunchDetailUiState()
    data class Success(val launch: Launch) : LaunchDetailUiState()
    object Error : LaunchDetailUiState()
}
