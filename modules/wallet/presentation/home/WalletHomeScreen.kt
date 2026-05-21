package com.aledaas.compose_app_starter.modules.wallet.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.aledaas.compose_app_starter.core.components.AppCard
import com.aledaas.compose_app_starter.core.components.AppPrimaryButton
import com.aledaas.compose_app_starter.core.components.AppSecondaryButton
import com.aledaas.compose_app_starter.core.components.AppSection
import com.aledaas.compose_app_starter.core.components.AppStatus
import com.aledaas.compose_app_starter.core.components.AppStatusBadge
import com.aledaas.compose_app_starter.core.designsystem.AppSpacing
import com.aledaas.compose_app_starter.core.layout.AppPage
import com.aledaas.compose_app_starter.core.layout.AppResponsiveGrid

@Composable
fun WalletHomeScreen() {
    AppPage {
        AppResponsiveGrid(
            primary = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(AppSpacing.lg)
                ) {
                    BalanceHeader()
                    BearerCashCard()
                    WalletActions()
                }
            },
            secondary = {
                LatestActivity()
            }
        )
    }
}

@Composable
private fun BalanceHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "Available balance",
                style = MaterialTheme.typography.labelLarge
            )

            Text(
                text = "$1,240.00",
                style = MaterialTheme.typography.headlineLarge
            )
        }

        AppStatusBadge(status = AppStatus.Offline)
    }
}

@Composable
private fun BearerCashCard() {
    AppCard(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(AppSpacing.sm)
        ) {
            Text(
                text = "Bearer Cash",
                style = MaterialTheme.typography.titleLarge
            )

            Text(
                text = "Create, receive and reconcile offline digital cash drafts.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
private fun WalletActions() {
    AppSection(title = "Actions") {
        Column(
            verticalArrangement = Arrangement.spacedBy(AppSpacing.sm)
        ) {
            AppPrimaryButton(
                text = "Create Bearer Cash",
                onClick = {}
            )

            AppSecondaryButton(
                text = "Receive Bearer Cash",
                onClick = {}
            )
        }
    }
}

@Composable
private fun LatestActivity() {
    AppSection(title = "Latest activity") {
        AppCard(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "No activity yet.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}