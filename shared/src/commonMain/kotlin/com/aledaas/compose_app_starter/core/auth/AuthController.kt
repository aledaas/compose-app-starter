package com.aledaas.compose_app_starter.core.auth

import androidx.compose.runtime.mutableStateOf
import com.aledaas.compose_app_starter.core.security.BiometricAuthResult
import com.aledaas.compose_app_starter.core.security.BiometricAuthenticator
import com.aledaas.compose_app_starter.core.security.BiometricAvailability
import com.aledaas.compose_app_starter.core.security.PinAuthResult
import com.aledaas.compose_app_starter.core.security.PinAuthenticator
import com.aledaas.compose_app_starter.modules.auth.application.SignInUseCase
import com.aledaas.compose_app_starter.modules.auth.application.SignOutUseCase
import com.aledaas.compose_app_starter.modules.auth.domain.AuthCredentials
import com.aledaas.compose_app_starter.modules.auth.presentation.BiometricUiState
import com.aledaas.compose_app_starter.modules.auth.presentation.LoginUiState

class AuthController(
    private val signInUseCase: SignInUseCase,
    private val signOutUseCase: SignOutUseCase,
    private val sessionManager: SessionManager,
    private val biometricAuthenticator: BiometricAuthenticator,
    private val pinAuthenticator: PinAuthenticator
) {
    val authState = mutableStateOf<AuthState>(AuthState.Unknown)
    val loginUiState = mutableStateOf<LoginUiState>(LoginUiState.Idle)
    val biometricUiState = mutableStateOf<BiometricUiState>(BiometricUiState.Unknown)
    val pinErrorMessage = mutableStateOf<String?>(null)

    suspend fun restoreSession() {
        authState.value = AuthState.Unknown

        val restoredState = sessionManager.restore()

        authState.value = when {
            restoredState is AuthState.Authenticated -> restoredState
            pinAuthenticator.isConfigured() -> AuthState.Locked
            else -> AuthState.Unauthenticated
        }
    }

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
            pinErrorMessage.value = null

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
        pinErrorMessage.value = null
    }

    suspend fun checkBiometrics() {
        biometricUiState.value = when (biometricAuthenticator.availability()) {
            BiometricAvailability.Available -> BiometricUiState.Available
            else -> BiometricUiState.Unavailable
        }
    }

    suspend fun biometricSignIn(): Boolean {
        biometricUiState.value = BiometricUiState.Authenticating

        return when (
            biometricAuthenticator.authenticate(
                reason = "Unlock your account"
            )
        ) {
            BiometricAuthResult.Success -> {
                authState.value = AuthState.Authenticated(
                    session = AuthSession(
                        accessToken = "biometric-token",
                        user = AuthUser(
                            id = "1",
                            name = "Alejandro",
                            email = "alejandro@demo.com"
                        )
                    )
                )

                biometricUiState.value = BiometricUiState.Available
                pinErrorMessage.value = null

                true
            }

            else -> {
                biometricUiState.value = BiometricUiState.Available
                false
            }
        }
    }

    suspend fun pinUnlock(pin: String): Boolean {
        pinErrorMessage.value = null

        return when (pinAuthenticator.authenticate(pin)) {
            PinAuthResult.Success -> {
                authState.value = AuthState.Authenticated(
                    session = AuthSession(
                        accessToken = "pin-token",
                        user = AuthUser(
                            id = "1",
                            name = "Alejandro",
                            email = "alejandro@demo.com"
                        )
                    )
                )

                true
            }

            PinAuthResult.InvalidPin -> {
                pinErrorMessage.value = "Invalid PIN"
                false
            }

            is PinAuthResult.Error -> {
                pinErrorMessage.value = "Unable to unlock with PIN"
                false
            }
        }
    }
}