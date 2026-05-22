package com.aledaas.compose_app_starter.core.onboarding

interface OnboardingRepository {
    suspend fun currentStatus(): OnboardingStatus
    suspend fun start(): OnboardingSession
    suspend fun refresh(): OnboardingStatus
}