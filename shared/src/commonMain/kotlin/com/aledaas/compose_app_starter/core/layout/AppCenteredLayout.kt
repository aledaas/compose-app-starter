package com.aledaas.compose_app_starter.core.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.aledaas.compose_app_starter.core.designsystem.AppSpacing

@Composable
fun AppCenteredLayout(
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(AppSpacing.xl),

            verticalArrangement = Arrangement.spacedBy(AppSpacing.xl)
        ) {
            content()
        }
    }
}