package com.akexorcist.kotlin.multiplatform.ui.extension

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun Dp.px() = with(LocalDensity.current) { this@px.toPx() }
