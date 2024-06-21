package com.akexorcist.kotlin.multiplatform.ui.component.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.akexorcist.kotlin.multiplatform.ui.component.*
import com.akexorcist.kotlin.multiplatform.ui.theme.BackgroundColor
import com.akexorcist.kotlin.multiplatform.ui.theme.scaled
import com.akexorcist.kotlin.multiplatform.ui.theme.scaledDp

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
                    vertical = VerticalScreenPadding.scaled(),
                    horizontal = HorizontalScreenPadding.scaled(),
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
                        Spacer(modifier = Modifier.height(16.scaledDp()))
                        ContentText(
                            modifier = Modifier.wrapContentHeight(),
                            text = subtitle,
                            fontWeight = FontWeight.Bold,
                        )
                        Spacer(modifier = Modifier.height(16.scaledDp()))
                        SmallContentText(
                            modifier = Modifier.fillMaxWidth(),
                            text = description,
                        )
                    }
                    if (index != contents.lastIndex) {
                        Spacer(modifier = Modifier.width(96.scaledDp()))
                    }
                }
            }
        }
    }
}