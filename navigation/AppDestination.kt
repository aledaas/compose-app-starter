package com.aledaas.compose_app_starter.core.navigation

enum class AppDestination(
    val label: String,
    val title: String,
    val iconLabel: String
) {
    WalletHome(
        label = "Home",
        title = "Wallet",
        iconLabel = "H"
    ),
    CreateBearerCash(
        label = "Create",
        title = "Create Bearer Cash",
        iconLabel = "+"
    ),
    ReceiveBearerCash(
        label = "Receive",
        title = "Receive Bearer Cash",
        iconLabel = "R"
    ),
    Ledger(
        label = "Ledger",
        title = "Ledger",
        iconLabel = "L"
    ),
    Sync(
        label = "Sync",
        title = "Sync",
        iconLabel = "S"
    )
}