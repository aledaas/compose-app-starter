package com.aledaas.compose_app_starter.modules.auth.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.aledaas.compose_app_starter.core.designsystem.AppSpacing
import com.aledaas.compose_app_starter.core.layout.AppCenteredLayout
import com.aledaas.compose_app_starter.core.layout.AppContentContainer

@Composable
fun AuthScaffold(
    config: AuthModuleConfig,
    content: @Composable () -> Unit
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
                        text = config.loginTitle,
                        style = MaterialTheme.typography.headlineLarge
                    )

                    Text(
                        text = config.loginSubtitle,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                content()
            }
        }
    }
}