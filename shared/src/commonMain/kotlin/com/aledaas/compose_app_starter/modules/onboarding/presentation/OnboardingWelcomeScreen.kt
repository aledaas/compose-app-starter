package com.aledaas.compose_app_starter.modules.onboarding.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.aledaas.compose_app_starter.core.components.AppPrimaryButton
import com.aledaas.compose_app_starter.core.components.AppSecondaryButton
import com.aledaas.compose_app_starter.core.designsystem.AppSpacing
import com.aledaas.compose_app_starter.core.layout.AppCenteredLayout
import com.aledaas.compose_app_starter.core.layout.AppContentContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

@Composable
fun OnboardingWelcomeScreen(
    onStart: () -> Unit,
    onRefresh: () -> Unit
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
                        text = "Complete onboarding",
                        style = MaterialTheme.typography.headlineLarge
                    )

                    Text(
                        text = "We need to verify your profile before enabling wallet operations.",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(AppSpacing.md)
                ) {
                    AppPrimaryButton(
                        text = "Start onboarding",
                        onClick = onStart
                    )

                    AppSecondaryButton(
                        text = "Refresh status",
                        onClick = onRefresh
                    )
                }
            }
        }
    }
}