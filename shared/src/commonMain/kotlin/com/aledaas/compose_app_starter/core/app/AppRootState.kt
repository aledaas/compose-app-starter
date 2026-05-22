package com.aledaas.compose_app_starter.core.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import com.aledaas.compose_app_starter.core.auth.AuthState
import com.aledaas.compose_app_starter.core.components.AppLoadingState
import com.aledaas.compose_app_starter.core.di.AppContainer
import com.aledaas.compose_app_starter.core.navigation.AppNavigation
import com.aledaas.compose_app_starter.core.onboarding.OnboardingStatus
import com.aledaas.compose_app_starter.modules.auth.presentation.BiometricUiState
import com.aledaas.compose_app_starter.modules.auth.presentation.LoginScreen
import com.aledaas.compose_app_starter.modules.auth.presentation.PinUnlockScreen
import com.aledaas.compose_app_starter.modules.onboarding.presentation.OnboardingPendingScreen
import com.aledaas.compose_app_starter.modules.onboarding.presentation.OnboardingRejectedScreen
import com.aledaas.compose_app_starter.modules.onboarding.presentation.OnboardingWelcomeScreen
import kotlinx.coroutines.launch

@Composable
fun AppRootState() {

    val authState by AppContainer.authController.authState
    val loginUiState by AppContainer.authController.loginUiState
    val biometricUiState by AppContainer.authController.biometricUiState
    val pinErrorMessage by AppContainer.authController.pinErrorMessage

    val onboardingStatus by
    AppContainer.onboardingController.status

    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {

        AppContainer.authController.restoreSession()

        AppContainer.authController.checkBiometrics()

        AppContainer.onboardingController.restore()
    }

    when (authState) {

        AuthState.Unknown -> {

            AppLoadingState(
                message = "Restoring session..."
            )
        }

        AuthState.Locked -> {

            PinUnlockScreen(
                errorMessage = pinErrorMessage,

                onUnlock = { pin ->

                    coroutineScope.launch {

                        val unlocked =
                            AppContainer.authController
                                .pinUnlock(pin)

                        if (unlocked) {

                            AppContainer.feedbackController.show(
                                message = "Unlocked with PIN"
                            )
                        }
                    }
                }
            )
        }

        AuthState.Unauthenticated -> {

            LoginScreen(
                uiState = loginUiState,

                biometricAvailable =
                    biometricUiState
                            is BiometricUiState.Available,

                onSignIn = { email, password ->

                    coroutineScope.launch {

                        val signedIn =
                            AppContainer.authController
                                .signIn(
                                    email = email,
                                    password = password
                                )

                        if (signedIn) {

                            AppContainer.feedbackController.show(
                                message =
                                    "Successfully signed in"
                            )
                        }
                    }
                },

                onBiometricSignIn = {

                    coroutineScope.launch {

                        val authenticated =
                            AppContainer.authController
                                .biometricSignIn()

                        if (authenticated) {

                            AppContainer.feedbackController.show(
                                message =
                                    "Unlocked with biometrics"
                            )
                        }
                    }
                }
            )
        }

        is AuthState.Authenticated -> {

            when (onboardingStatus) {

                OnboardingStatus.Unknown -> {

                    AppLoadingState(
                        message = "Loading onboarding..."
                    )
                }

                OnboardingStatus.NotStarted,
                OnboardingStatus.InProgress -> {

                    OnboardingWelcomeScreen(

                        onStart = {

                            coroutineScope.launch {

                                AppContainer
                                    .onboardingController
                                    .start()
                            }
                        },

                        onRefresh = {

                            coroutineScope.launch {

                                AppContainer
                                    .onboardingController
                                    .refresh()
                            }
                        }
                    )
                }

                OnboardingStatus.PendingReview -> {

                    OnboardingPendingScreen(

                        onRefresh = {

                            coroutineScope.launch {

                                AppContainer
                                    .onboardingController
                                    .refresh()
                            }
                        }
                    )
                }

                is OnboardingStatus.Rejected -> {

                    val rejected =
                        onboardingStatus as OnboardingStatus.Rejected

                    OnboardingRejectedScreen(

                        reason = rejected.reason,

                        onRestart = {

                            coroutineScope.launch {

                                AppContainer
                                    .onboardingController
                                    .start()
                            }
                        }
                    )
                }

                OnboardingStatus.Approved -> {

                    AppNavigation()
                }
            }
        }
    }
}