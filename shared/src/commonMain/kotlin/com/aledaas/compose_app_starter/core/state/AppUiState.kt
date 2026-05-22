package com.aledaas.compose_app_starter.core.state

sealed interface AppUiState {

    data object Idle : AppUiState

    data object Loading : AppUiState

    data class Success<T>(
        val data: T
    ) : AppUiState

    data class Error(
        val message: String
    ) : AppUiState
}