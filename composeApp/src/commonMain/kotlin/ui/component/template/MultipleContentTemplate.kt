package ui.component.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ui.component.*
import ui.theme.BackgroundColor

@Composable
fun MultipleContentTemplate(
    title: String,
    contents: List<Pair<String, String>>,
    tag: TagData? = null,
) {
    Row(
        modifier = Modifier.background(BackgroundColor.White.color),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
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
            Spacer(modifier = Modifier.height(32.dp))
            Row(modifier = Modifier.fillMaxSize()) {
                contents.forEachIndexed { index, (subtitle, content) ->
                    Column(modifier = Modifier.weight(1f)) {
                        ContentText(
                            modifier = Modifier.wrapContentHeight(),
                            text = subtitle,
                            fontWeight = FontWeight.SemiBold,
                        )
                        SmallContentText(
                            modifier = Modifier.fillMaxWidth(),
                            text = content,
                        )
                    }
                    if (index != contents.lastIndex) {
                        Spacer(modifier = Modifier.width(36.dp))
                    }
                }
            }
        }
    }
}