package com.aledaas.compose_app_starter.core.feedback

import androidx.compose.runtime.mutableStateOf

class AppFeedbackController {
    val currentMessage = mutableStateOf<AppFeedbackMessage?>(null)

    fun show(message: String, type: AppFeedbackType = AppFeedbackType.Info) {
        currentMessage.value = AppFeedbackMessage(
            message = message,
            type = type
        )
    }

    fun clear() {
        currentMessage.value = null
    }
}