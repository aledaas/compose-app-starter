package com.aledaas.compose_app_starter.core.hostedflow

sealed interface HostedFlowResult {
    data object Completed : HostedFlowResult
    data object Cancelled : HostedFlowResult

    data class Failed(
        val message: String
    ) : HostedFlowResult
}