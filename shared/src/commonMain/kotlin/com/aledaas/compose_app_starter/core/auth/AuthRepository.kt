package com.aledaas.compose_app_starter.core.auth

interface AuthRepository {
    suspend fun currentSession(): AuthSession?
    suspend fun signIn(email: String, password: String): AuthSession
    suspend fun signOut()
}