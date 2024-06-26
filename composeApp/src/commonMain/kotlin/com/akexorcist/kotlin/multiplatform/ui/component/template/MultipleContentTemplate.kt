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

@Composable
fun MultipleContentTemplate(
    title: String,
    contents: List<Pair<String, String>>,
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
            Spacer(modifier = Modifier.height(48.scaledDp()))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.Bottom,
            ) {
                TitleText(
                    modifier = Modifier.fillMaxWidth(),
                    text = title,
                )
                Spacer(modifier = Modifier.height(32.scaledDp()))
            }
            Spacer(modifier = Modifier.height(32.scaledDp()))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f)
            ) {
                contents.forEachIndexed { index, (subtitle, content) ->
                    Column(modifier = Modifier.weight(1f)) {
                        LargeContentText(
                            modifier = Modifier.wrapContentHeight(),
                            text = subtitle,
                            fontWeight = FontWeight.SemiBold,
                        )
                        Spacer(modifier = Modifier.height(24.scaledDp()))
                        ContentText(
                            modifier = Modifier.fillMaxWidth(),
                            text = content,
                        )
                    }
                    if (index != contents.lastIndex) {
                        Spacer(modifier = Modifier.width(64.scaledDp()))
                    }
                }
            }
        }
    }
}