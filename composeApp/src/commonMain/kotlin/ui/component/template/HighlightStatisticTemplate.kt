package ui.component.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ui.component.ContentText
import ui.component.HighlightText
import ui.theme.BackgroundColor

@Composable
fun HighlightStatisticTemplate(
    highlight: String,
    description: String,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor.White.color)
            .padding(64.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        HighlightText(
            modifier = Modifier.wrapContentSize(),
            text = highlight,
        )
        ContentText(
            modifier = Modifier.fillMaxWidth(0.5f),
            text = description,
            fontWeight = FontWeight.Medium,
            alignment = TextAlign.Center,
        )
    }
}