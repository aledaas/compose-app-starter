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
fun OnboardingPendingScreen(
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
                        text = "Review in progress",
                        style = MaterialTheme.typography.headlineLarge
                    )

                    Text(
                        text = "Your onboarding is being reviewed. You will be able to continue once it is approved.",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                AppPrimaryButton(
                    text = "Refresh status",
                    onClick = onRefresh
                )
            }
        }
    }
}