package com.aledaas.compose_app_starter.core.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.aledaas.compose_app_starter.core.feedback.AppFeedbackMessage
import com.aledaas.compose_app_starter.core.feedback.AppFeedbackType

@Composable
fun AppSnackbarHost(
    message: AppFeedbackMessage
) {
    Snackbar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = when (message.type) {
            AppFeedbackType.Info -> MaterialTheme.colorScheme.primary
            AppFeedbackType.Success -> MaterialTheme.colorScheme.primary
            AppFeedbackType.Warning -> MaterialTheme.colorScheme.tertiary
            AppFeedbackType.Error -> MaterialTheme.colorScheme.error
        }
    ) {
        Text(
            text = message.message,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}