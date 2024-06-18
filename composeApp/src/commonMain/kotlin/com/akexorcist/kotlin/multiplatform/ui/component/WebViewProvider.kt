package com.akexorcist.kotlin.multiplatform.ui.component

import androidx.compose.runtime.Composable

@Composable
expect fun WebViewProvider(content: @Composable () -> Unit)
