package com.akexorcist.kotlin.multiplatform.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object AppTypography {
    @Composable
    fun default() = MaterialTheme.typography.copy(
        h4 = MaterialTheme.typography.h4.copy(
            lineHeight = 48.sp,
        ),
    )

    @Composable
    fun small() = MaterialTheme.typography.copy(
        h1 = MaterialTheme.typography.h1.copy(
            fontWeight = FontWeight.Light,
            fontSize = 96.sp * 0.65,
            lineHeight = 112.sp * 0.65,
            letterSpacing = (-1.5).sp * 0.65,
        ),
        h2 = MaterialTheme.typography.h2.copy(
            fontWeight = FontWeight.Light,
            fontSize = 60.sp * 0.7,
            lineHeight = 72.sp * 0.7,
            letterSpacing = (-0.5).sp * 0.7,
        ),
        h3 = MaterialTheme.typography.h3.copy(
            fontWeight = FontWeight.Normal,
            fontSize = 48.sp * 0.75,
            lineHeight = 56.sp * 0.75,
            letterSpacing = 0.sp * 0.75,
        ),
        h4 = MaterialTheme.typography.h4.copy(
            lineHeight = 48.sp * 0.8,

            fontWeight = FontWeight.Normal,
            fontSize = 34.sp * 0.8,
//            lineHeight = 36.sp,
            letterSpacing = 0.25.sp * 0.8,
        ),
        h5 = MaterialTheme.typography.h5.copy(
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp * 0.85,
            lineHeight = 24.sp * 0.85,
            letterSpacing = 0.sp * 0.85,
        ),
        h6 = MaterialTheme.typography.h6.copy(
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp * 0.9,
            lineHeight = 24.sp * 0.9,
            letterSpacing = 0.15.sp * 0.9,
        ),
    )
}