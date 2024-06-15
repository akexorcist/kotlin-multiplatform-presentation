package com.akexorcist.kotlin.multiplatform.ui.component.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.akexorcist.kotlin.multiplatform.ui.theme.BackgroundColor

@Composable
fun FullCustomTemplate(
    background: BackgroundColor = BackgroundColor.White,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(background.color),
        contentAlignment = Alignment.Center,
    ) {
        content()
    }
}
