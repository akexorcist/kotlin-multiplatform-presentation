package com.akexorcist.kotlin.multiplatform.ui.component.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.akexorcist.kotlin.multiplatform.ui.component.*
import com.akexorcist.kotlin.multiplatform.ui.theme.BackgroundColor
import com.akexorcist.kotlin.multiplatform.ui.theme.GradientColor

@Composable
fun LargeFrameTemplate(
    title: String,
    description: String,
    tag: TagData? = null,
    frameColor: GradientColor = GradientColor.BlueRed,
    content: @Composable BoxScope.() -> Unit,
) {
    Row(
        modifier = Modifier
            .background(BackgroundColor.White.color)
            .fillMaxSize()
            .padding(64.dp),
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
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
            SmallContentText(
                modifier = Modifier.fillMaxWidth(),
                text = description,
            )
        }
        Spacer(Modifier.width(64.dp))
        DoubleFrame(
            modifier = Modifier
                .weight(2f)
                .fillMaxHeight(),
            gradientColor = frameColor,
            content = content
        )
    }
}