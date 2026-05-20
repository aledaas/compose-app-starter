package com.aledaas.compose_app_starter.core.layout

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

enum class AppWindowSizeClass {
    Compact,
    Medium,
    Expanded
}

@Composable
fun ResponsiveLayout(
    compact: @Composable () -> Unit,
    medium: @Composable () -> Unit = compact,
    expanded: @Composable () -> Unit = medium
) {
    BoxWithConstraints {
        when {
            maxWidth < 600.dp -> compact()
            maxWidth < 840.dp -> medium()
            else -> expanded()
        }
    }
}