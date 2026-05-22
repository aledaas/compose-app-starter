package com.aledaas.compose_app_starter.core.di

import com.aledaas.compose_app_starter.core.auth.AuthController
import com.aledaas.compose_app_starter.core.auth.AuthRepository
import com.aledaas.compose_app_starter.core.auth.AuthSession
import com.aledaas.compose_app_starter.core.auth.AuthUser
import com.aledaas.compose_app_starter.modules.auth.application.SignInUseCase
import com.aledaas.compose_app_starter.modules.auth.application.SignOutUseCase
import kotlinx.coroutines.delay
import com.aledaas.compose_app_starter.core.feedback.AppFeedbackController
import com.aledaas.compose_app_starter.core.auth.SessionManager
import com.aledaas.compose_app_starter.core.security.BiometricAuthenticator
import com.aledaas.compose_app_starter.core.security.FakeBiometricAuthenticator

object AppContainer {

    val authRepository: AuthRepository by lazy {
        FakeAuthRepository()
    }

    val signInUseCase: SignInUseCase by lazy {
        SignInUseCase(authRepository)
    }

    val signOutUseCase: SignOutUseCase by lazy {
        SignOutUseCase(authRepository)
    }

    val authController: AuthController by lazy {
        AuthController(
            signInUseCase = signInUseCase,
            signOutUseCase = signOutUseCase,
            sessionManager = sessionManager
        )
    }
    val feedbackController: AppFeedbackController by lazy {
        AppFeedbackController()
    }
    val sessionManager: SessionManager by lazy {
        SessionManager(authRepository)
    }
    val biometricAuthenticator: BiometricAuthenticator by lazy {
        FakeBiometricAuthenticator()
    }
}

private class FakeAuthRepository : AuthRepository {

    private var session: AuthSession? = null

    override suspend fun currentSession(): AuthSession? {
        return session
    }

    override suspend fun signIn(
        email: String,
        password: String
    ): AuthSession {

        delay(1500)

        session = AuthSession(
            accessToken = "fake-token",
            user = AuthUser(
                id = "1",
                name = "Alejandro",
                email = email
            )
        )

        return session!!
    }

    override suspend fun signOut() {
        session = null
    }
}