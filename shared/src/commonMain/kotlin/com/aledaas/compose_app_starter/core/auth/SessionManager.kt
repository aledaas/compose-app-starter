package com.aledaas.compose_app_starter.core.auth

class SessionManager(
    private val authRepository: AuthRepository
) {

    suspend fun restore(): AuthState {

        val session = authRepository.currentSession()

        return if (session != null) {
            AuthState.Authenticated(session)
        } else {
            AuthState.Unauthenticated
        }
    }
}