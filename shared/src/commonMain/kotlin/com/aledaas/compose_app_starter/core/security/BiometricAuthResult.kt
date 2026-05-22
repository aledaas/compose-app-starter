package com.aledaas.compose_app_starter.core.security

sealed interface BiometricAuthResult {

    data object Success : BiometricAuthResult

    data object Cancelled : BiometricAuthResult

    data class Error(
        val message: String
    ) : BiometricAuthResult
}