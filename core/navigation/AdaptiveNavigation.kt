package com.aledaas.compose_app_starter.core.navigation

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun AppBottomNavigationBar(
    currentDestination: AppDestination,
    onDestinationSelected: (AppDestination) -> Unit
) {
    NavigationBar {
        AppDestination.entries.forEach { destination ->
            NavigationBarItem(
                selected = currentDestination == destination,
                onClick = {
                    onDestinationSelected(destination)
                },
                icon = {
                    Text(text = destination.iconLabel)
                },
                label = {
                    Text(text = destination.label)
                }
            )
        }
    }
}

@Composable
fun AppNavigationRail(
    currentDestination: AppDestination,
    onDestinationSelected: (AppDestination) -> Unit
) {
    NavigationRail {
        AppDestination.entries.forEach { destination ->
            NavigationRailItem(
                selected = currentDestination == destination,
                onClick = {
                    onDestinationSelected(destination)
                },
                icon = {
                    Text(text = destination.iconLabel)
                },
                label = {
                    Text(text = destination.label)
                }
            )
        }
    }
}