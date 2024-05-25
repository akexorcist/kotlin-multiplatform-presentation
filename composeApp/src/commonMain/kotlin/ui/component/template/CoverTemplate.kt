package ui.component.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ui.component.EventLogo
import ui.component.Tag
import ui.component.TagData
import ui.theme.BackgroundColor
import ui.theme.ThemeColors

@Composable
fun CoverTemplate(
    title: String,
    backgroundColor: BackgroundColor = BackgroundColor.Blue,
    tag: TagData? = null,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor.color)
            .padding(64.dp)
    ) {
        Box(modifier = Modifier.wrapContentHeight().fillMaxWidth()) {
            EventLogo()
        }
        Row(
            modifier = Modifier.weight(2f).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier.weight(3f),
                text = title,
                fontSize = MaterialTheme.typography.h1.fontSize,
                color = ThemeColors.TextPrimary,
                fontStyle = MaterialTheme.typography.h1.fontStyle,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = MaterialTheme.typography.h1.letterSpacing,
                lineHeight = MaterialTheme.typography.h1.lineHeight,
            )
            Spacer(modifier = Modifier.weight(1f))
        }
        if (tag != null) {
            Box(modifier = Modifier.wrapContentHeight().fillMaxWidth()) {
                Tag(data = tag)
            }
        }
    }
}
