package com.aledaas.compose_app_starter.core.onboarding

import androidx.compose.runtime.mutableStateOf

class OnboardingController(
    private val repository: OnboardingRepository
) {

    val status =
        mutableStateOf<OnboardingStatus>(
            OnboardingStatus.Unknown
        )

    suspend fun restore() {
        status.value = repository.currentStatus()
    }

    suspend fun start() {
        val session = repository.start()
        status.value = session.status
    }

    suspend fun refresh() {
        status.value = repository.refresh()
    }
}