package com.aledaas.compose_app_starter.modules.auth.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import com.aledaas.compose_app_starter.core.components.AppPrimaryButton
import com.aledaas.compose_app_starter.core.components.form.AppPasswordField
import com.aledaas.compose_app_starter.core.components.form.AppTextField
import com.aledaas.compose_app_starter.core.designsystem.AppSpacing

@Composable
fun LoginScreen(
    config: AuthModuleConfig = AuthModuleConfig(),
    onSignIn: (email: String, password: String) -> Unit = { _, _ -> }
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    AuthScaffold(config = config) {
        Column(
            verticalArrangement = Arrangement.spacedBy(AppSpacing.md)
        ) {
            AppTextField(
                value = email,
                onValueChange = { email = it },
                label = "Email"
            )

            AppPasswordField(
                value = password,
                onValueChange = { password = it },
                label = "Password"
            )

            AppPrimaryButton(
                text = "Sign in",
                enabled = email.isNotBlank() && password.isNotBlank(),
                onClick = {
                    onSignIn(email, password)
                }
            )
        }
    }
}