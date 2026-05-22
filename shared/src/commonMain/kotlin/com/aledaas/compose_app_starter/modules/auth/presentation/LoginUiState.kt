package com.aledaas.compose_app_starter.modules.auth.presentation

sealed interface LoginUiState {
    data object Idle : LoginUiState
    data object Loading : LoginUiState
    data class Error(
        val message: String
    ) : LoginUiState
}