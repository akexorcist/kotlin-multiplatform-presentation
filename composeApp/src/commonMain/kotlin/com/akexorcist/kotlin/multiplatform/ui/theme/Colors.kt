package com.akexorcist.kotlin.multiplatform.ui.theme

import androidx.compose.ui.graphics.Color

object ThemeColors {
    val BluePrimary = Color(0xFF428EFF)

    val TextPrimary = Color(0xFF202124)

    val DarkBackground = Color(0xFF1E1F22)
    val BorderPrimary = TextPrimary
    val White = Color.White

    val BlueEvent = Color(0xFF4285F4)
    val GreenEvent = Color(0xFF34A853)
    val YellowEvent = Color(0xFFFBBC04)
    val RedEvent = Color(0xFFEA4335)
    val PurpleBlend = Color(0xFF9F6CD4)
    val OrangeBlend = Color(0xFFF46831)
    val GreenBlend = Color(0xFFAEBC44)
    val GrayEvent = Color(0xFFEEEEEE)
}

sealed class BackgroundColor(val color: Color) {
    data object White : BackgroundColor(Color.White)
    data object GrayEvent : BackgroundColor(ThemeColors.GrayEvent)
    data object Code : BackgroundColor(ThemeColors.DarkBackground)
    data object Bar : BackgroundColor(ThemeColors.White)
}

sealed class GradientColor(
    val from: Color,
    val middle: Color,
    val to: Color
) {
    data object BlueRed : GradientColor(
        from = ThemeColors.BlueEvent,
        middle = ThemeColors.PurpleBlend,
        to = ThemeColors.RedEvent,
    )

    data object YellowGreen : GradientColor(
        from = ThemeColors.YellowEvent,
        middle = ThemeColors.GreenBlend,
        to = ThemeColors.GreenEvent,
    )

    data object YellowRed : GradientColor(
        from = ThemeColors.YellowEvent,
        middle = ThemeColors.OrangeBlend,
        to = ThemeColors.RedEvent,
    )
}

sealed class TextColor(val color: Color) {
    data object Default : TextColor(ThemeColors.TextPrimary)
    data object Blue : TextColor(ThemeColors.BlueEvent)
}

sealed class ContentColor(val color: Color) {
    data object Default : ContentColor(ThemeColors.TextPrimary)
    data object Blue : ContentColor(ThemeColors.BluePrimary)
    data object White : ContentColor(ThemeColors.White)
}
