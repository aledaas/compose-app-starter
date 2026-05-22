package com.aledaas.compose_app_starter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.aledaas.compose_app_starter.core.auth.AuthState
import com.aledaas.compose_app_starter.core.designsystem.AppTheme
import com.aledaas.compose_app_starter.core.di.AppContainer
import com.aledaas.compose_app_starter.core.navigation.AppNavigation
import com.aledaas.compose_app_starter.modules.auth.presentation.LoginScreen
import kotlinx.coroutines.launch
import androidx.compose.runtime.rememberCoroutineScope

@Composable
@Preview
fun App() {
    AppTheme {
        val authState by AppContainer.authController.authState
        val coroutineScope = rememberCoroutineScope()

        when (authState) {
            AuthState.Unknown,
            AuthState.Unauthenticated -> {
                LoginScreen(
                    onSignIn = { email, password ->
                        coroutineScope.launch {
                            AppContainer.authController.signIn(email, password)
                        }
                    }
                )
            }

            is AuthState.Authenticated -> {
                AppNavigation()
            }
        }
    }
}