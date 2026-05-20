package com.aledaas.compose_app_starter.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.aledaas.compose_app_starter.core.layout.AdaptiveScaffold
import com.aledaas.compose_app_starter.core.layout.ScreenContainer
import com.aledaas.compose_app_starter.modules.wallet.WalletModule

@Composable
fun AppNavigation() {
    var currentDestination by remember {
        mutableStateOf(AppDestination.WalletHome)
    }

    AdaptiveScaffold(
        title = currentDestination.title,
        navigationBar = {
            AppBottomNavigationBar(
                currentDestination = currentDestination,
                onDestinationSelected = {
                    currentDestination = it
                }
            )
        },
        navigationRail = {
            AppNavigationRail(
                currentDestination = currentDestination,
                onDestinationSelected = {
                    currentDestination = it
                }
            )
        }
    ) { paddingValues ->
        ScreenContainer(paddingValues) {
            WalletModule(
                destination = currentDestination
            )
        }
    }
}