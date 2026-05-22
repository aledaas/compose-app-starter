package com.aledaas.compose_app_starter.core.onboarding

sealed interface OnboardingStatus {
    data object Unknown : OnboardingStatus
    data object NotStarted : OnboardingStatus
    data object InProgress : OnboardingStatus
    data object PendingReview : OnboardingStatus
    data object Approved : OnboardingStatus

    data class Rejected(
        val reason: String
    ) : OnboardingStatus
}