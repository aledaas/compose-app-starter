package com.aledaas.compose_app_starter.infrastructure.onboarding

import com.aledaas.compose_app_starter.core.network.ApiClient
import com.aledaas.compose_app_starter.core.onboarding.OnboardingRepository
import com.aledaas.compose_app_starter.core.onboarding.OnboardingSession
import com.aledaas.compose_app_starter.core.onboarding.OnboardingStatus
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import kotlinx.serialization.Serializable

class RemoteOnboardingRepository(
    private val apiClient: ApiClient
) : OnboardingRepository {

    override suspend fun currentStatus(): OnboardingStatus {
        val response = apiClient.httpClient
            .get("${apiClient.config.baseUrl}/api/mobile/onboarding/status")
            .body<OnboardingStatusResponse>()

        return response.toDomain()
    }

    override suspend fun start(): OnboardingSession {
        val response = apiClient.httpClient
            .post("${apiClient.config.baseUrl}/api/mobile/onboarding/start")
            .body<OnboardingSessionResponse>()

        return response.toDomain()
    }

    override suspend fun refresh(): OnboardingStatus {
        val response = apiClient.httpClient
            .post("${apiClient.config.baseUrl}/api/mobile/onboarding/refresh")
            .body<OnboardingStatusResponse>()

        return response.toDomain()
    }
}

@Serializable
private data class OnboardingStatusResponse(
    val status: String,
    val reason: String? = null
) {
    fun toDomain(): OnboardingStatus {
        return when (status) {
            "not_started" -> OnboardingStatus.NotStarted
            "in_progress" -> OnboardingStatus.InProgress
            "pending_review" -> OnboardingStatus.PendingReview
            "approved" -> OnboardingStatus.Approved
            "rejected" -> OnboardingStatus.Rejected(
                reason = reason ?: "Rejected"
            )
            else -> OnboardingStatus.Unknown
        }
    }
}

@Serializable
private data class OnboardingSessionResponse(
    val id: String,
    val provider: String,
    val redirect_url: String? = null,
    val status: String
) {
    fun toDomain(): OnboardingSession {
        return OnboardingSession(
            id = id,
            provider = provider,
            redirectUrl = redirect_url,
            status = OnboardingStatusResponse(status).toDomain()
        )
    }
}