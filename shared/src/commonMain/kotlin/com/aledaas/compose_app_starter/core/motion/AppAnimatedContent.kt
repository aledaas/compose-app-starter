package com.aledaas.compose_app_starter.core.motion

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun <T> AppAnimatedContent(
    targetState: T,
    content: @Composable (T) -> Unit
) {
    AnimatedContent(
        targetState = targetState,
        transitionSpec = {
            fadeIn(
                animationSpec = AppAnimations.MediumTween
            ) togetherWith fadeOut(
                animationSpec = AppAnimations.FastTween
            )
        },
        label = "AppAnimatedContent"
    ) { state ->
        content(state)
    }
}