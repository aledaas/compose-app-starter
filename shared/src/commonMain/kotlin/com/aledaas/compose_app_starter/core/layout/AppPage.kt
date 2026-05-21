package com.aledaas.compose_app_starter.core.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.aledaas.compose_app_starter.core.designsystem.AppSpacing

@Composable
fun AppPage(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = AppContentPadding.compact,
    verticalArrangement: Arrangement.Vertical = Arrangement.spacedBy(AppSpacing.lg),
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(contentPadding),
        verticalArrangement = verticalArrangement
    ) {
        content()
    }
}