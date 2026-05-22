package com.aledaas.compose_app_starter.core.auth

import androidx.compose.runtime.mutableStateOf
import com.aledaas.compose_app_starter.modules.auth.application.SignInUseCase
import com.aledaas.compose_app_starter.modules.auth.application.SignOutUseCase
import com.aledaas.compose_app_starter.modules.auth.domain.AuthCredentials

class AuthController(
    private val signInUseCase: SignInUseCase,
    private val signOutUseCase: SignOutUseCase
) {
    val authState = mutableStateOf<AuthState>(AuthState.Unauthenticated)

    suspend fun signIn(email: String, password: String) {
        val session = signInUseCase(
            AuthCredentials(
                email = email,
                password = password
            )
        )

        authState.value = AuthState.Authenticated(session)
    }

    suspend fun signOut() {
        signOutUseCase()
        authState.value = AuthState.Unauthenticated
    }
}