package com.aledaas.compose_app_starter.core.onboarding

interface OnboardingProvider {
    suspend fun start(): OnboardingSession
    suspend fun status(): OnboardingStatus
    suspend fun refresh(): OnboardingStatus
}