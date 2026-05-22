package com.aledaas.compose_app_starter.core.auth

sealed interface AuthState {
    data object Unknown : AuthState

    data object Unauthenticated : AuthState

    data object Locked : AuthState

    data class Authenticated(
        val session: AuthSession
    ) : AuthState
}