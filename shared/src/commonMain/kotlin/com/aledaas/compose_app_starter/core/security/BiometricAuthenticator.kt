package com.aledaas.compose_app_starter.core.security

interface BiometricAuthenticator {

    suspend fun availability(): BiometricAvailability

    suspend fun authenticate(
        reason: String
    ): BiometricAuthResult
}