package com.lpirro.launch_detail.mission.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lpirro.domain.usecase.GetLaunchDetailOverviewUseCase
import com.lpirro.launch_detail.mission.mapper.LaunchMissionMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LaunchDetailMissionViewModel @Inject constructor(
    private val getLaunchDetailOverviewUseCase: GetLaunchDetailOverviewUseCase,
    private val mapper: LaunchMissionMapper
) : ViewModel(), LaunchDetailMissionViewModelContract {

    private val _uiState =
        MutableStateFlow<LaunchDetailMissionUiState>(LaunchDetailMissionUiState.Loading)
    val uiState: StateFlow<LaunchDetailMissionUiState> = _uiState

    override fun getLaunch(id: String) = viewModelScope.launch {
        try {
            getLaunchDetailOverviewUseCase(id).collect { launch ->
                _uiState.value = LaunchDetailMissionUiState.Success(mapper.mapToUi(launch))
            }
        } catch (e: java.lang.Exception) {
            _uiState.value = LaunchDetailMissionUiState.Error
            Timber.d(e)
        }
    }

    override fun retry() {
        TODO("Not yet implemented")
    }
}
