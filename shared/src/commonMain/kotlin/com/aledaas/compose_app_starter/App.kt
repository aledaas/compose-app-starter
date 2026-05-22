package com.aledaas.compose_app_starter

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aledaas.compose_app_starter.core.app.AppRootState
import com.aledaas.compose_app_starter.core.components.AppSnackbarHost
import com.aledaas.compose_app_starter.core.designsystem.AppSpacing
import com.aledaas.compose_app_starter.core.designsystem.AppTheme
import com.aledaas.compose_app_starter.core.di.AppContainer
import kotlinx.coroutines.delay

@Composable
@Preview
fun App() {

    AppTheme {

        val feedbackMessage by
        AppContainer.feedbackController.currentMessage

        LaunchedEffect(feedbackMessage) {

            if (feedbackMessage != null) {

                delay(3000)

                AppContainer.feedbackController.clear()
            }
        }

        Box(
            modifier = Modifier.fillMaxSize()
        ) {

            AppRootState()

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