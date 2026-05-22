package com.aledaas.compose_app_starter.core.auth

import androidx.compose.runtime.mutableStateOf
import com.aledaas.compose_app_starter.modules.auth.application.SignInUseCase
import com.aledaas.compose_app_starter.modules.auth.application.SignOutUseCase
import com.aledaas.compose_app_starter.modules.auth.domain.AuthCredentials
import com.aledaas.compose_app_starter.modules.auth.presentation.LoginUiState

class AuthController(
    private val signInUseCase: SignInUseCase,
    private val signOutUseCase: SignOutUseCase
) {
    val authState = mutableStateOf<AuthState>(AuthState.Unauthenticated)
    val loginUiState = mutableStateOf<LoginUiState>(LoginUiState.Idle)

    suspend fun signIn(email: String, password: String): Boolean {
        loginUiState.value = LoginUiState.Loading

        return try {
            val session = signInUseCase(
                AuthCredentials(
                    email = email,
                    password = password
                )
            )

            authState.value = AuthState.Authenticated(session)
            loginUiState.value = LoginUiState.Idle

            true
        } catch (exception: Exception) {
            loginUiState.value = LoginUiState.Error(
                message = exception.message ?: "Unable to sign in"
            )

            false
        }
    }

    suspend fun signOut() {
        signOutUseCase()
        authState.value = AuthState.Unauthenticated
        loginUiState.value = LoginUiState.Idle
    }
}