package com.aledaas.compose_app_starter

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aledaas.compose_app_starter.core.auth.AuthState
import com.aledaas.compose_app_starter.core.components.AppLoadingState
import com.aledaas.compose_app_starter.core.components.AppSnackbarHost
import com.aledaas.compose_app_starter.core.designsystem.AppSpacing
import com.aledaas.compose_app_starter.core.designsystem.AppTheme
import com.aledaas.compose_app_starter.core.di.AppContainer
import com.aledaas.compose_app_starter.core.navigation.AppNavigation
import com.aledaas.compose_app_starter.modules.auth.presentation.LoginScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
@Preview
fun App() {
    AppTheme {
        val authState by AppContainer.authController.authState
        val loginUiState by AppContainer.authController.loginUiState
        val feedbackMessage by AppContainer.feedbackController.currentMessage
        val coroutineScope = rememberCoroutineScope()

        LaunchedEffect(Unit) {
            AppContainer.authController.restoreSession()
        }

        LaunchedEffect(feedbackMessage) {
            if (feedbackMessage != null) {
                delay(3000)
                AppContainer.feedbackController.clear()
            }
        }

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            when (authState) {
                AuthState.Unknown -> {
                    AppLoadingState(
                        message = "Restoring session..."
                    )
                }

                AuthState.Unauthenticated -> {
                    LoginScreen(
                        uiState = loginUiState,
                        onSignIn = { email, password ->
                            coroutineScope.launch {
                                val signedIn = AppContainer.authController.signIn(
                                    email,
                                    password
                                )

                                if (signedIn) {
                                    AppContainer.feedbackController.show(
                                        message = "Successfully signed in"
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

            feedbackMessage?.let { message ->
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(AppSpacing.lg)
                ) {
                    AppSnackbarHost(message)
                }
            }
        }
    }
}