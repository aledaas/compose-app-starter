package com.aledaas.compose_app_starter.core.layout

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppScaffold(
    bottomBar: @Composable () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = Modifier.safeContentPadding(),
        bottomBar = bottomBar,
        content = content
    )
}