package com.aledaas.compose_app_starter.core.navigation

enum class AppDestination(
    val label: String
) {
    WalletHome("Home"),
    CreateBearerCash("Create"),
    ReceiveBearerCash("Receive"),
    Ledger("Ledger"),
    Sync("Sync")
}