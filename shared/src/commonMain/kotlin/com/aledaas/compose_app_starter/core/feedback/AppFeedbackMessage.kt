package com.aledaas.compose_app_starter.core.feedback

data class AppFeedbackMessage(
    val message: String,
    val type: AppFeedbackType = AppFeedbackType.Info
)

enum class AppFeedbackType {
    Info,
    Success,
    Error,
    Warning
}