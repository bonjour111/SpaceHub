package com.lpirro.launch_detail.mission.viewmodel

import com.lpirro.launch_detail.mission.model.LaunchMissionItem

sealed class LaunchDetailMissionUiState {
    object Loading : LaunchDetailMissionUiState()
    data class Success(val launchMission: List<LaunchMissionItem>) : LaunchDetailMissionUiState()
    object Error : LaunchDetailMissionUiState()
}
