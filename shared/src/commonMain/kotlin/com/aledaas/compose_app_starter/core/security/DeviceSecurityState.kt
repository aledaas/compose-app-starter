package com.aledaas.compose_app_starter.core.security

data class DeviceSecurityState(
    val biometricsAvailable: Boolean,
    val deviceSecure: Boolean
)