package com.aledaas.compose_app_starter.core.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import com.aledaas.compose_app_starter.core.auth.AuthState
import com.aledaas.compose_app_starter.core.components.AppLoadingState
import com.aledaas.compose_app_starter.core.di.AppContainer
import com.aledaas.compose_app_starter.core.navigation.AppNavigation
import com.aledaas.compose_app_starter.modules.auth.presentation.BiometricUiState
import com.aledaas.compose_app_starter.modules.auth.presentation.LoginScreen
import kotlinx.coroutines.launch

@Composable
fun AppRootState() {
    val authState by AppContainer.authController.authState
    val loginUiState by AppContainer.authController.loginUiState
    val biometricUiState by AppContainer.authController.biometricUiState

    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        AppContainer.authController.restoreSession()
        AppContainer.authController.checkBiometrics()
    }

    when (authState) {
        AuthState.Unknown -> {
            AppLoadingState(
                message = "Restoring session..."
            )
        }

        AuthState.Unauthenticated -> {
            LoginScreen(
                uiState = loginUiState,
                biometricAvailable = biometricUiState is BiometricUiState.Available,
                onSignIn = { email, password ->
                    coroutineScope.launch {
                        val signedIn = AppContainer.authController.signIn(
                            email = email,
                            password = password
                        )

                        if (signedIn) {
                            AppContainer.feedbackController.show(
                                message = "Successfully signed in"
                            )
                        }
                    }
                },
                onBiometricSignIn = {
                    coroutineScope.launch {
                        val authenticated = AppContainer.authController.biometricSignIn()

                        if (authenticated) {
                            AppContainer.feedbackController.show(
                                message = "Unlocked with biometrics"
                            )
                        }
                    }
                }
            )
        }

        is AuthState.Authenticated -> {
            AppNavigation()
        }
    }
}