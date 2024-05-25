package ui.component.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.theme.BackgroundColor

@Composable
fun FullCustomTemplate(
    content: @Composable () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor.White.color)
            .padding(64.dp),
        contentAlignment = Alignment.Center,
    ) {
        content()
    }
}
