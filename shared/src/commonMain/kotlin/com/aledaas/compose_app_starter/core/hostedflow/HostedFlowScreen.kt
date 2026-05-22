package com.aledaas.compose_app_starter.modules.hostedflow.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.aledaas.compose_app_starter.core.components.AppPrimaryButton
import com.aledaas.compose_app_starter.core.components.AppSecondaryButton
import com.aledaas.compose_app_starter.core.designsystem.AppSpacing
import com.aledaas.compose_app_starter.core.hostedflow.HostedFlowSession
import com.aledaas.compose_app_starter.core.layout.AppCenteredLayout
import com.aledaas.compose_app_starter.core.layout.AppContentContainer

@Composable
fun HostedFlowScreen(
    session: HostedFlowSession,
    onOpen: (url: String) -> Unit,
    onCompleted: () -> Unit,
    onCancelled: () -> Unit
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
                        text = "Continue verification",
                        style = MaterialTheme.typography.headlineLarge
                    )

                    Text(
                        text = "Provider: ${session.provider}",
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Text(
                        text = "Open the hosted verification flow to continue.",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(AppSpacing.md)
                ) {
                    AppPrimaryButton(
                        text = "Open verification",
                        onClick = {
                            onOpen(session.url)
                        }
                    )

                    AppSecondaryButton(
                        text = "I completed verification",
                        onClick = onCompleted
                    )

                    AppSecondaryButton(
                        text = "Cancel",
                        onClick = onCancelled
                    )
                }
            }
        }
    }
}