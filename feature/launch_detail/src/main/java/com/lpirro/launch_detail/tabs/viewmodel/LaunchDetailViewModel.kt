package com.lpirro.launch_detail.tabs.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lpirro.domain.usecase.GetLaunchDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchDetailViewModel @Inject constructor(
    private val stateHandle: SavedStateHandle,
    private val getLaunchDetailUseCase: GetLaunchDetailUseCase
) : ViewModel(), LaunchDetailViewModelContract {

    private val _uiState =
        MutableStateFlow<LaunchDetailUiState>(LaunchDetailUiState.Loading)
    val uiState: StateFlow<LaunchDetailUiState> = _uiState

    override fun getLaunch(id: String) = viewModelScope.launch {
        try {
            getLaunchDetailUseCase(id).collect { launch ->
                _uiState.value = LaunchDetailUiState.Success(launch)
            }
        } catch (e: java.lang.Exception) {
            _uiState.value = LaunchDetailUiState.Error
        }
    }

    override fun retry() {
        TODO("Not yet implemented")
    }
}
