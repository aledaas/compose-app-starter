package com.aledaas.compose_app_starter.core.components.form

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation

@Composable
fun AppPasswordField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),

        value = value,

        onValueChange = onValueChange,

        label = {
            Text(label)
        },

        singleLine = true,

        shape = MaterialTheme.shapes.medium,

        visualTransformation = PasswordVisualTransformation(),

        colors = OutlinedTextFieldDefaults.colors()
    )
}