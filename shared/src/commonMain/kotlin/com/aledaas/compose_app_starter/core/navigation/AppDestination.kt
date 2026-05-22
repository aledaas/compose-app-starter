package com.aledaas.compose_app_starter.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBalanceWallet
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Download
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Sync
import androidx.compose.ui.graphics.vector.ImageVector

enum class AppDestination(
    val label: String,
    val title: String,
    val icon: ImageVector
) {

    WalletHome(
        label = "Home",
        title = "Wallet",
        icon = Icons.Outlined.AccountBalanceWallet
    ),

    CreateBearerCash(
        label = "Create",
        title = "Create Bearer Cash",
        icon = Icons.Outlined.AddCircle
    ),

    ReceiveBearerCash(
        label = "Receive",
        title = "Receive Bearer Cash",
        icon = Icons.Outlined.Download
    ),

    Ledger(
        label = "Ledger",
        title = "Ledger",
        icon = Icons.Outlined.History
    ),

    Sync(
        label = "Sync",
        title = "Sync",
        icon = Icons.Outlined.Sync
    )
}