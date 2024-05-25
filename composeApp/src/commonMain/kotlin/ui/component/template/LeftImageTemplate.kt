package ui.component.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import ui.component.ContentText
import ui.component.Tag
import ui.component.TagData
import ui.component.TitleText
import ui.theme.BackgroundColor

@Composable
fun LeftImageTemplate(
    title: String,
    content: String,
    image: DrawableResource,
    tag: TagData? = null,
) {
    Row(
        modifier = Modifier.background(BackgroundColor.White.color),
    ) {
        Box(modifier = Modifier.weight(1f)) {
            Spacer(
                modifier = Modifier.background(BackgroundColor.Yellow.color).fillMaxSize()
            )
//        Image(
//            painter = painterResource(image),
//            contentDescription = "",
//        )
        }
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
    }
}