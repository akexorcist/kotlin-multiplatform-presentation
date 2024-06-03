package com.akexorcist.kotlin.multiplatform.ui.content.maps

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
actual fun MapContent(modifier: Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "Compose Multiplatform for web doesn't supports wih Map rendering, You have to build an UI with Compose HTML instead (which is not multiplatform).")
    }
}
