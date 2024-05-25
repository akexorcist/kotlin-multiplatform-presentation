package ui.component.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
fun RightImageTemplate(
    title: String,
    content: String,
    image: DrawableResource,
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
        Box(modifier = Modifier.weight(1f)) {
            Spacer(
                modifier = Modifier.background(BackgroundColor.Yellow.color).fillMaxSize()
            )
//        Image(
//            painter = painterResource(image),
//            contentDescription = "",
//        )
        }
    }
}