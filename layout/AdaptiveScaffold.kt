package com.aledaas.compose_app_starter.core.layout

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AdaptiveScaffold(
    title: String,
    navigationBar: @Composable () -> Unit,
    navigationRail: @Composable () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    ResponsiveLayout(
        compact = {
            Scaffold(
                modifier = Modifier.safeContentPadding(),
                topBar = {
                    AppTopBar(title = title)
                },
                bottomBar = navigationBar,
                content = content
            )
        },
        medium = {
            Row {
                navigationRail()

                Scaffold(
                    modifier = Modifier.safeContentPadding(),
                    topBar = {
                        AppTopBar(title = title)
                    },
                    content = content
                )
            }
        },
        expanded = {
            Row {
                navigationRail()

                Scaffold(
                    modifier = Modifier.safeContentPadding(),
                    topBar = {
                        AppTopBar(title = title)
                    },
                    content = content
                )
            }
        }
    )
}