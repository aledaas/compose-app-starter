package com.aledaas.compose_app_starter.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.aledaas.compose_app_starter.core.designsystem.AppOffline
import com.aledaas.compose_app_starter.core.designsystem.AppOnline
import com.aledaas.compose_app_starter.core.designsystem.AppSpacing

enum class AppStatus {
    Online,
    Offline
}

@Composable
fun AppStatusBadge(
    status: AppStatus,
    modifier: Modifier = Modifier
) {
    val label = when (status) {
        AppStatus.Online -> "Online"
        AppStatus.Offline -> "Offline"
    }

    val background = when (status) {
        AppStatus.Online -> AppOnline
        AppStatus.Offline -> AppOffline
    }

    Box(
        modifier = modifier
            .background(
                color = background,
                shape = MaterialTheme.shapes.small
            )
            .padding(
                horizontal = AppSpacing.sm,
                vertical = AppSpacing.xs
            )
    ) {
        Text(
            text = label,
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.labelMedium
        )
    }
}