package com.aledaas.compose_app_starter.modules.auth.presentation

import androidx.compose.runtime.Composable
import com.aledaas.compose_app_starter.core.components.AppSecondaryButton

@Composable
fun BiometricLoginButton(
    enabled: Boolean,
    onClick: () -> Unit
) {
    AppSecondaryButton(
        text = "Unlock with biometrics",
        enabled = enabled,
        onClick = onClick
    )
}