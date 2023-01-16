package com.lpirro.launches.past.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lpirro.domain.usecase.GetPastLaunchesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PastLaunchesViewModel @Inject constructor(
    private val getPastLaunchesUseCase: GetPastLaunchesUseCase
) : ViewModel(), PastLaunchesViewModelContract {

    private val _uiState =
        MutableStateFlow<PastLaunchesUiState>(PastLaunchesUiState.Loading)
    val uiState: StateFlow<PastLaunchesUiState> = _uiState

    init {
        getPastLaunches()
    }

    override fun getPastLaunches() = viewModelScope.launch {
        try {
            getPastLaunchesUseCase().collect { launches ->
                _uiState.value = PastLaunchesUiState.Refresh(isRefreshing = false)
                _uiState.value = PastLaunchesUiState.Success(launches)
            }
        } catch (e: Exception) {
            _uiState.value = PastLaunchesUiState.Refresh(isRefreshing = false)
            _uiState.value = PastLaunchesUiState.Error
        }
    }

    override fun refresh() {
        _uiState.value = PastLaunchesUiState.Refresh(isRefreshing = true)
        getPastLaunches()
    }
}
