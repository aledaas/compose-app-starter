package com.aledaas.compose_app_starter.core.onboarding

import kotlinx.coroutines.delay

class FakeOnboardingRepository : OnboardingRepository {

    private var status: OnboardingStatus = OnboardingStatus.NotStarted

    override suspend fun currentStatus(): OnboardingStatus {
        delay(500)
        return status
    }

    override suspend fun start(): OnboardingSession {
        delay(1000)

        status = OnboardingStatus.InProgress

        return OnboardingSession(
            id = "fake-onboarding-session",
            provider = "fake",
            redirectUrl = null,
            status = status
        )
    }

    override suspend fun refresh(): OnboardingStatus {
        delay(1000)

        status = OnboardingStatus.Approved

        return status
    }
}