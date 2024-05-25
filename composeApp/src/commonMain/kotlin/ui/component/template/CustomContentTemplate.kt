package ui.component.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.component.ContentText
import ui.component.Tag
import ui.component.TagData
import ui.component.TitleText
import ui.theme.BackgroundColor
import ui.theme.ThemeColors

@Composable
fun CustomContentTemplate(
    title: String,
    content: String,
    custom: @Composable () -> Unit,
    tag: TagData? = null,
) {
    Row(
        modifier = Modifier.background(BackgroundColor.White.color),
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .padding(64.dp)
        ) {
            if (tag != null) {
                Tag(data = tag)
                Spacer(modifier = Modifier.height(48.dp))
            }
            TitleText(
                modifier = Modifier.fillMaxWidth(),
                text = title,
            )
            Spacer(modifier = Modifier.height(24.dp))
            ContentText(
                modifier = Modifier.fillMaxWidth(),
                text = content,
            )
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(ThemeColors.GrayBackground),
        ) {
            custom()
        }
    }
}