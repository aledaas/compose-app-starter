package com.aledaas.compose_app_starter.core.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppContentContainer(
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier.widthIn(max = 420.dp)
    ) {
        content()
    }
}