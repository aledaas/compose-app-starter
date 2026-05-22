package com.aledaas.compose_app_starter.core.onboarding

data class OnboardingSession(
    val id: String,
    val provider: String,
    val redirectUrl: String? = null,
    val status: OnboardingStatus
)