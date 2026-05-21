package com.aledaas.compose_app_starter.core.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.aledaas.compose_app_starter.core.designsystem.AppSpacing

@Composable
fun AppResponsiveGrid(
    modifier: Modifier = Modifier,
    primary: @Composable () -> Unit,
    secondary: @Composable () -> Unit
) {
    ResponsiveLayout(
        compact = {
            Column(
                modifier = modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(AppSpacing.lg)
            ) {
                primary()
                secondary()
            }
        },
        medium = {
            AppGridRow(
                modifier = modifier.fillMaxWidth(),
                primary = primary,
                secondary = secondary
            )
        },
        expanded = {
            AppGridRow(
                modifier = modifier.fillMaxWidth(),
                primary = primary,
                secondary = secondary
            )
        }
    )
}

@Composable
private fun AppGridRow(
    modifier: Modifier = Modifier,
    primary: @Composable () -> Unit,
    secondary: @Composable () -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(AppSpacing.lg)
    ) {
        GridColumn { primary() }
        GridColumn { secondary() }
    }
}

@Composable
private fun RowScope.GridColumn(
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.weight(1f),
        verticalArrangement = Arrangement.spacedBy(AppSpacing.lg)
    ) {
        content()
    }
}