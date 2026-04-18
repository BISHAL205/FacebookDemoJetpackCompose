package com.example.jetpackcomposetest.ui.theme

import android.app.Activity
import android.graphics.Color
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary        = FacebookBlue,
    onPrimary      = androidx.compose.ui.graphics.Color.White,
    secondary      = FacebookBlueDark,
    background     = FacebookBg,
    surface        = FacebookSurface,
    onBackground   = FacebookTextPrimary,
    onSurface      = FacebookTextPrimary,
    outline        = FacebookDivider
)

private val LightColorScheme = lightColorScheme(
    primary        = FacebookBlue,
    onPrimary      = androidx.compose.ui.graphics.Color.White,
    secondary      = FacebookBlueDark,
    background     = FacebookBg,
    surface        = FacebookSurface,
    onBackground   = FacebookTextPrimary,
    onSurface      = FacebookTextPrimary,
    outline        = FacebookDivider
)

@Composable
fun JetpackComposeTestTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = FacebookTypography,
        content = content
    )
}