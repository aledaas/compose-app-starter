package com.aledaas.compose_app_starter.core.security

import kotlinx.coroutines.delay

class FakeBiometricAuthenticator : BiometricAuthenticator {

    override suspend fun availability(): BiometricAvailability {

        delay(500)

        return BiometricAvailability.Available
    }

    override suspend fun authenticate(
        reason: String
    ): BiometricAuthResult {

        delay(1500)

        return BiometricAuthResult.Success
    }
}