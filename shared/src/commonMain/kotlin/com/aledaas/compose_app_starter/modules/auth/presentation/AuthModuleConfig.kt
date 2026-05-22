package com.aledaas.compose_app_starter.modules.auth.presentation

data class AuthModuleConfig(
    val appName: String = "Compose App Starter",
    val loginTitle: String = "Welcome back",
    val loginSubtitle: String = "Sign in to continue",
    val allowRegister: Boolean = true,
    val allowForgotPassword: Boolean = true,
    val allowBiometrics: Boolean = true
)