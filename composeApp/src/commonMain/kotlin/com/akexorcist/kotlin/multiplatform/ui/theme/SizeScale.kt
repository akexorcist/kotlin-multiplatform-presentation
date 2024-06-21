package com.akexorcist.kotlin.multiplatform.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class SizeScale(
    val scale: Float,
)

val LocalSizeScale = staticCompositionLocalOf {
    SizeScale(1f)
}

@Composable
fun Dp.scaled(): Dp = with(LocalSizeScale.current) { this@scaled * scale }

@Composable
fun Int.scaledDp(): Dp = with(LocalSizeScale.current) { this@scaledDp.dp * scale }

@Composable
fun Float.scaledDp(): Dp = with(LocalSizeScale.current) { this@scaledDp.dp * scale }

@Composable
fun Double.scaledDp(): Dp = with(LocalSizeScale.current) { this@scaledDp.dp * scale }
