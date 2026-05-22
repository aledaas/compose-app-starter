package com.aledaas.compose_app_starter.modules.auth.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.aledaas.compose_app_starter.core.components.AppErrorState
import com.aledaas.compose_app_starter.core.components.AppPrimaryButton
import com.aledaas.compose_app_starter.core.components.form.AppTextField
import com.aledaas.compose_app_starter.core.designsystem.AppSpacing

@Composable
fun PinUnlockScreen(
    errorMessage: String? = null,
    onUnlock: (pin: String) -> Unit
) {
    var pin by remember { mutableStateOf("") }

    AuthScaffold(
        config = AuthModuleConfig(
            loginTitle = "Unlock app",
            loginSubtitle = "Enter your PIN to continue"
        )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(AppSpacing.md)
        ) {
            AppTextField(
                value = pin,
                onValueChange = { pin = it },
                label = "PIN"
            )

            errorMessage?.let {
                AppErrorState(message = it)
            }

            AppPrimaryButton(
                text = "Unlock",
                enabled = pin.length >= 4,
                onClick = {
                    onUnlock(pin)
                }
            )
        }
    }
}