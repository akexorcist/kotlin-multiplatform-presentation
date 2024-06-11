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

    val DarkBackground = Color(0xFF1E1F22)
    val BlackTransparent30 = Color(0x0A000000)
    val BorderPrimary = TextPrimary
    val White = Color.White

    val BlueEvent = Color(0xFF4285F4)
    val GreenEvent = Color(0xFF34A853)
    val YellowEvent = Color(0xFFFBBC04)
    val RedEvent = Color(0xFFEA4335)
    val YellowBlend = Color(0xFFFFCB32)
    val PurpleBlend = Color(0xFF9F6CD4)
    val OrangeBlend = Color(0xFFF46831)
    val GreenBlend = Color(0xFFAEBC44)
    val GrayEvent = Color(0xFFEEEEEE)
}

sealed class BackgroundColor(val color: Color) {
    data object Green : BackgroundColor(ThemeColors.GreenPrimary)
    data object Yellow : BackgroundColor(ThemeColors.YellowPrimary)
    data object Blue : BackgroundColor(ThemeColors.BluePrimary)
    data object White : BackgroundColor(Color.White)
    data object GrayEvent : BackgroundColor(ThemeColors.GrayEvent)
    data object Code : BackgroundColor(ThemeColors.DarkBackground)
    data object IconButton : BackgroundColor(ThemeColors.BlackTransparent30)
    data object Bar : BackgroundColor(ThemeColors.White)
}

sealed class TagColor(val color: Color) {
    data object Green : TagColor(ThemeColors.GreenLight)
    data object Yellow : TagColor(ThemeColors.YellowLight)
    data object Blue : TagColor(ThemeColors.BlueLight)
    data object White : TagColor(Color.White)
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
    data object Default : TagColor(ThemeColors.TextPrimary)
    data object Blue : TagColor(ThemeColors.BluePrimary)
}

sealed class ContentColor(val color: Color) {
    data object Default : ContentColor(ThemeColors.TextPrimary)
    data object Blue : TagColor(ThemeColors.BluePrimary)
}