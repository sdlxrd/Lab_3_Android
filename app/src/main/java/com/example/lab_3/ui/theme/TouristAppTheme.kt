package com.example.lab_3.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// Vibrant travel-inspired colors
private val VibrantPurple = Color(0xFF9C27B0)
private val TropicalGreen = Color(0xFF00E676)
private val SunriseYellow = Color(0xFFFFEB3B)
private val CoralPink = Color(0xFFFF4081)
private val TurquoiseBlue = Color(0xFF00BCD4)
private val LavenderPurple = Color(0xFFE1BEE7)
private val ParadiseOrange = Color(0xFFFF5722)

private val DarkColorScheme = darkColorScheme(
    primary = VibrantPurple,
    onPrimary = Color.White,
    secondary = TropicalGreen,
    onSecondary = Color.Black,
    tertiary = CoralPink,
    background = Color(0xFF2D1B36),
    surface = Color(0xFF1E1E1E),
    onBackground = TurquoiseBlue,
    onSurface = LavenderPurple
)

private val LightColorScheme = lightColorScheme(
    primary = VibrantPurple,
    onPrimary = Color.White,
    secondary = ParadiseOrange,
    onSecondary = Color.White,
    tertiary = TropicalGreen,
    background = LavenderPurple.copy(alpha = 0.3f),
    surface = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = VibrantPurple
)

@Composable
fun TouristAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Set to false to use our custom colors
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
        typography = Typography,
        content = content
    )
}
