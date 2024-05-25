package ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ui.theme.TagColor
import ui.theme.ThemeColors

data class TagData(
    val text: String,
    val background: TagColor,
)

@Composable
fun Tag(data: TagData) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .background(
                color = data.background.color,
                shape = RoundedCornerShape(100),
            )
            .border(
                width = 2.dp,
                color = ThemeColors.BorderPrimary,
                shape = RoundedCornerShape(100),
            )
            .padding(horizontal = 48.dp, vertical = 16.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = data.text,
            fontSize = MaterialTheme.typography.h5.fontSize,
            color = ThemeColors.TextPrimary,
            fontStyle = MaterialTheme.typography.h5.fontStyle,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = MaterialTheme.typography.h5.letterSpacing,
            lineHeight = MaterialTheme.typography.h5.lineHeight,
        )
    }
}
