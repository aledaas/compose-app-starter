package com.aledaas.compose_app_starter.core.security

sealed interface PinAuthResult {
    data object Success : PinAuthResult
    data object InvalidPin : PinAuthResult
    data class Error(
        val message: String
    ) : PinAuthResult
}