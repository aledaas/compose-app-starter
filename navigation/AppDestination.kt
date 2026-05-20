package com.aledaas.compose_app_starter.core.navigation

enum class AppDestination(
    val label: String,
    val title: String
) {
    WalletHome(
        label = "Home",
        title = "Wallet"
    ),
    CreateBearerCash(
        label = "Create",
        title = "Create Bearer Cash"
    ),
    ReceiveBearerCash(
        label = "Receive",
        title = "Receive Bearer Cash"
    ),
    Ledger(
        label = "Ledger",
        title = "Ledger"
    ),
    Sync(
        label = "Sync",
        title = "Sync"
    )
}