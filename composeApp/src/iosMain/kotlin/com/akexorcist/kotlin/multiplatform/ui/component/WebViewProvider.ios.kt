package com.akexorcist.kotlin.multiplatform.ui.component

import androidx.compose.runtime.Composable

@Composable
actual fun WebViewProvider(content: @Composable () -> Unit) {
    content()
}
