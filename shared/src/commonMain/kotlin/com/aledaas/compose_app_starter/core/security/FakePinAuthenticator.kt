package com.aledaas.compose_app_starter.core.security

import kotlinx.coroutines.delay

class FakePinAuthenticator : PinAuthenticator {

    private var storedPin: String? = "1234"

    override suspend fun isConfigured(): Boolean {
        delay(300)
        return storedPin != null
    }

    override suspend fun configure(pin: String) {
        delay(300)
        storedPin = pin
    }

    override suspend fun authenticate(pin: String): PinAuthResult {
        delay(800)

        return if (pin == storedPin) {
            PinAuthResult.Success
        } else {
            PinAuthResult.InvalidPin
        }
    }

    override suspend fun clear() {
        storedPin = null
    }
}