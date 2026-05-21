package com.aledaas.compose_app_starter.core.designsystem

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors: ColorScheme = lightColorScheme(
    primary = AppPrimary,
    onPrimary = AppOnPrimary,

    background = AppBackgroundLight,
    onBackground = AppOnBackgroundLight,

    surface = AppSurfaceLight,
    onSurface = AppOnSurfaceLight,

    error = AppError
)

private val DarkColors: ColorScheme = darkColorScheme(
    primary = AppPrimary,
    onPrimary = AppOnPrimary,

    background = AppBackgroundDark,
    onBackground = AppOnBackgroundDark,

    surface = AppSurfaceDark,
    onSurface = AppOnSurfaceDark,

    error = AppError
)

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    val colors = if (isSystemInDarkTheme()) {
        DarkColors
    } else {
        LightColors
    }

    MaterialTheme(
        colorScheme = colors,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}