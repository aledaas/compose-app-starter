package com.aledaas.compose_app_starter.modules.auth.presentation

sealed interface BiometricUiState {

    data object Unknown : BiometricUiState

    data object Available : BiometricUiState

    data object Unavailable : BiometricUiState

    data object Authenticating : BiometricUiState
}