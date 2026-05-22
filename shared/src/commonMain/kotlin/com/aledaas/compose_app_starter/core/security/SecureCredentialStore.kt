package com.aledaas.compose_app_starter.core.security

interface SecureCredentialStore {

    suspend fun save(
        key: String,
        value: String
    )

    suspend fun get(
        key: String
    ): String?

    suspend fun clear(
        key: String
    )
}