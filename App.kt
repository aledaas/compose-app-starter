package com.aledaas.compose_app_starter

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.aledaas.compose_app_starter.core.designsystem.AppTheme
import com.aledaas.compose_app_starter.core.navigation.AppNavigation

@Composable
@Preview
fun App() {
    AppTheme {
        AppNavigation()
    }
}