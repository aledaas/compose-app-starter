package com.aledaas.compose_app_starter.modules.auth.application

import com.aledaas.compose_app_starter.core.auth.AuthRepository
import com.aledaas.compose_app_starter.core.auth.AuthSession
import com.aledaas.compose_app_starter.modules.auth.domain.AuthCredentials

class SignInUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(credentials: AuthCredentials): AuthSession {
        return authRepository.signIn(
            email = credentials.email,
            password = credentials.password
        )
    }
}