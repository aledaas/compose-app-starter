package com.aledaas.compose_app_starter.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.aledaas.compose_app_starter.core.layout.AdaptiveScaffold
import com.aledaas.compose_app_starter.core.layout.ScreenContainer
import com.aledaas.compose_app_starter.core.motion.AppAnimatedContent
import com.aledaas.compose_app_starter.modules.wallet.WalletModule

@Composable
fun AppNavigation() {
    var currentDestination by remember {
        mutableStateOf(AppDestination.WalletHome)
    }

    fun navigateTo(destination: AppDestination) {
        if (destination == currentDestination) {
            return
        }

        currentDestination = destination
    }

    AdaptiveScaffold(
        title = currentDestination.title,
        navigationBar = {
            AppBottomNavigationBar(
                currentDestination = currentDestination,
                onDestinationSelected = ::navigateTo
            )
        },
        navigationRail = {
            AppNavigationRail(
                currentDestination = currentDestination,
                onDestinationSelected = ::navigateTo
            )
        }
    ) { paddingValues ->
        ScreenContainer(paddingValues) {
            AppAnimatedContent(
                targetState = currentDestination
            ) { destination ->
                WalletModule(destination = destination)
            }
        }
    }
}