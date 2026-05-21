package com.aledaas.compose_app_starter.modules.wallet

import androidx.compose.runtime.Composable
import com.aledaas.compose_app_starter.core.navigation.AppDestination
import com.aledaas.compose_app_starter.modules.wallet.presentation.create.CreateBearerCashScreen
import com.aledaas.compose_app_starter.modules.wallet.presentation.home.WalletHomeScreen
import com.aledaas.compose_app_starter.modules.wallet.presentation.ledger.LedgerScreen
import com.aledaas.compose_app_starter.modules.wallet.presentation.receive.ReceiveBearerCashScreen
import com.aledaas.compose_app_starter.modules.wallet.presentation.sync.SyncScreen

@Composable
fun WalletModule(
    destination: AppDestination
) {
    when (destination) {
        AppDestination.WalletHome -> WalletHomeScreen()
        AppDestination.CreateBearerCash -> CreateBearerCashScreen()
        AppDestination.ReceiveBearerCash -> ReceiveBearerCashScreen()
        AppDestination.Ledger -> LedgerScreen()
        AppDestination.Sync -> SyncScreen()
    }
}