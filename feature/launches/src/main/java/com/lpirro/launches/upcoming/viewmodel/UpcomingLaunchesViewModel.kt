package com.lpirro.launches.upcoming.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lpirro.domain.usecase.GetUpcomingLaunchesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpcomingLaunchesViewModel @Inject constructor(
    private val getUpcomingLaunchesUseCase: GetUpcomingLaunchesUseCase
) : ViewModel(), UpcomingLaunchesViewModelContract {

    private val _uiState =
        MutableStateFlow<UpcomingLaunchesUiState>(UpcomingLaunchesUiState.Loading)
    val uiState: StateFlow<UpcomingLaunchesUiState> = _uiState

    init {
        getUpcomingLaunches()
    }

    override fun getUpcomingLaunches() = viewModelScope.launch {
        try {
            getUpcomingLaunchesUseCase().collect { launches ->
                _uiState.value = UpcomingLaunchesUiState.Refresh(isRefreshing = false)
                _uiState.value = UpcomingLaunchesUiState.Success(launches)
            }
        } catch (e: Exception) {
            _uiState.value = UpcomingLaunchesUiState.Refresh(isRefreshing = false)
            _uiState.value = UpcomingLaunchesUiState.Error
        }
    }

    override fun refresh() {
        _uiState.value = UpcomingLaunchesUiState.Refresh(isRefreshing = true)
        getUpcomingLaunches()
    }
}
