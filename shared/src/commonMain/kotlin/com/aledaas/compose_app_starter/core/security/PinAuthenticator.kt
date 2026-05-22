package com.aledaas.compose_app_starter.core.security

interface PinAuthenticator {
    suspend fun isConfigured(): Boolean
    suspend fun configure(pin: String)
    suspend fun authenticate(pin: String): PinAuthResult
    suspend fun clear()
}