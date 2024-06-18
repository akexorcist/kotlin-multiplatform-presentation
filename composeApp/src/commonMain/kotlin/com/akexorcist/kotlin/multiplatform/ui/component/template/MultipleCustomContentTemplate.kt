package com.akexorcist.kotlin.multiplatform.ui.component.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.akexorcist.kotlin.multiplatform.ui.component.*
import com.akexorcist.kotlin.multiplatform.ui.theme.BackgroundColor

data class CustomContentItem(
    val weight: Float = 1f,
    val title: String,
    val description: String,
    val content: @Composable () -> Unit,
)

@Composable
fun MultipleCustomContentTemplate(
    contents: List<CustomContentItem>,
    tag: TagData,
) {
    Row(
        modifier = Modifier.background(BackgroundColor.GrayEvent.color),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    vertical = VerticalScreenPadding,
                    horizontal = HorizontalScreenPadding,
                ),
        ) {
            Tag(data = tag)
            Spacer(modifier = Modifier.weight(0.5f))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f),
                horizontalArrangement = Arrangement.Center,
            ) {
                contents.forEachIndexed { index, (weight, subtitle, description, content) ->
                    Column(modifier = Modifier.weight(weight)) {
                        content()
                        Spacer(modifier = Modifier.height(16.dp))
                        ContentText(
                            modifier = Modifier.wrapContentHeight(),
                            text = subtitle,
                            fontWeight = FontWeight.Bold,
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        SmallContentText(
                            modifier = Modifier.fillMaxWidth(),
                            text = description,
                        )
                    }
                    if (index != contents.lastIndex) {
                        Spacer(modifier = Modifier.width(96.dp))
                    }
                }
            }
        }
    }
}