package com.aledaas.compose_app_starter.modules.onboarding.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import com.aledaas.compose_app_starter.core.components.AppPrimaryButton
import com.aledaas.compose_app_starter.core.designsystem.AppSpacing
import com.aledaas.compose_app_starter.core.layout.AppCenteredLayout
import com.aledaas.compose_app_starter.core.layout.AppContentContainer

@Composable
fun OnboardingRejectedScreen(
    reason: String,
    onRestart: () -> Unit
) {
    AppCenteredLayout {
        AppContentContainer {
            Column(
                verticalArrangement = Arrangement.spacedBy(AppSpacing.xl)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(AppSpacing.sm)
                ) {
                    Text(
                        text = "Onboarding rejected",
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.error
                    )

                    Text(
                        text = reason,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                AppPrimaryButton(
                    text = "Restart onboarding",
                    onClick = onRestart
                )
            }
        }
    }
}