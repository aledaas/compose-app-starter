package com.aledaas.compose_app_starter.core.auth

data class AuthSession(
    val accessToken: String,
    val refreshToken: String? = null,
    val user: AuthUser
)