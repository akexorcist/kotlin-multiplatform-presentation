package com.akexorcist.kotlin.multiplatform.ui.theme

import androidx.compose.ui.graphics.Color

object ThemeColors {
    val GreenLight = Color(0xFF80D592)
    val GreenPrimary = Color(0xFF38A852)

    val YellowLight = Color(0xFFFFD971)
    val YellowPrimary = Color(0xFFFFBB00)

    val BlueLight = Color(0xFF86B8FF)
    val BluePrimary = Color(0xFF428EFF)

    val TextPrimary = Color(0xFF202124)

    val GrayBackground = Color(0xFFE8EAED)
    val DarkBackground = Color(0xFF1E1F22)
    val BlackTransparent30 = Color(0x0A000000)
    val BorderPrimary = TextPrimary
}

sealed class BackgroundColor(val color: Color) {
    data object Green : BackgroundColor(ThemeColors.GreenPrimary)
    data object Yellow : BackgroundColor(ThemeColors.YellowPrimary)
    data object Blue : BackgroundColor(ThemeColors.BluePrimary)
    data object White : BackgroundColor(Color.White)
    data object Gray : BackgroundColor(ThemeColors.GrayBackground)
    data object Code : BackgroundColor(ThemeColors.DarkBackground)
    data object IconButton : BackgroundColor(ThemeColors.BlackTransparent30)
    data object Bar : BackgroundColor(ThemeColors.BlackTransparent30)
}

sealed class TagColor(val color: Color) {
    data object Green : TagColor(ThemeColors.GreenLight)
    data object Yellow : TagColor(ThemeColors.YellowLight)
    data object Blue : TagColor(ThemeColors.BlueLight)
    data object White : TagColor(Color.White)
}

sealed class TextColor(val color: Color) {
    data object Default : TagColor(ThemeColors.TextPrimary)
    data object Blue : TagColor(ThemeColors.BluePrimary)
}

sealed class ContentColor(val color: Color) {
    data object Default : ContentColor(ThemeColors.TextPrimary)
}