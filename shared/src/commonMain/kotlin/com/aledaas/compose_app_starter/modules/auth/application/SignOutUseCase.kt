package com.aledaas.compose_app_starter.modules.auth.application

import com.aledaas.compose_app_starter.core.auth.AuthRepository

class SignOutUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke() {
        authRepository.signOut()
    }
}