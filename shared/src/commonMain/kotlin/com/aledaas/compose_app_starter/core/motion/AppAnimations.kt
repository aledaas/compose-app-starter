package com.aledaas.compose_app_starter.core.motion

import androidx.compose.animation.core.EaseOutCubic
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.tween

object AppAnimations {
    const val FastDuration = 150
    const val MediumDuration = 250
    const val SlowDuration = 400

    val FastTween: TweenSpec<Float> = tween(
        durationMillis = FastDuration,
        easing = EaseOutCubic
    )

    val MediumTween: TweenSpec<Float> = tween(
        durationMillis = MediumDuration,
        easing = EaseOutCubic
    )

    val SlowTween: TweenSpec<Float> = tween(
        durationMillis = SlowDuration,
        easing = EaseOutCubic
    )
}