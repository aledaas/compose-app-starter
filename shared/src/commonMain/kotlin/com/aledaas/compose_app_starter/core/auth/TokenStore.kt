package com.aledaas.compose_app_starter.core.auth

interface TokenStore {
    suspend fun save(session: AuthSession)
    suspend fun get(): AuthSession?
    suspend fun clear()
}