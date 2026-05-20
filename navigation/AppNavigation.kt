package com.aledaas.compose_app_starter.core.navigation

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import com.aledaas.compose_app_starter.core.layout.AppScaffold
import com.aledaas.compose_app_starter.core.layout.ScreenContainer
import com.aledaas.compose_app_starter.modules.wallet.WalletModule

@Composable
fun AppNavigation() {
    var currentDestination by remember {
        mutableStateOf(AppDestination.WalletHome)
    }

    AppScaffold(
        title = currentDestination.title,
        bottomBar = {
            NavigationBar {
                AppDestination.entries.forEach { destination ->
                    NavigationBarItem(
                        selected = currentDestination == destination,
                        onClick = { currentDestination = destination },
                        label = { Text(destination.label) },
                        icon = {}
                    )
                }
            }
        }
    ) { paddingValues ->
        ScreenContainer(paddingValues) {
            WalletModule(
                destination = currentDestination
            )
        }
    }
}