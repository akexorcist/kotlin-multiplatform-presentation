package com.akexorcist.kotlin.multiplatform.ui.component.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.akexorcist.kotlin.multiplatform.ui.component.*
import com.akexorcist.kotlin.multiplatform.ui.theme.BackgroundColor
import com.akexorcist.kotlin.multiplatform.ui.theme.GradientColor
import com.akexorcist.kotlin.multiplatform.ui.theme.scaled
import com.akexorcist.kotlin.multiplatform.ui.theme.scaledDp

@Composable
fun RightFrameTemplate(
    title: String,
    description: String,
    tag: TagData,
    frameColor: GradientColor = GradientColor.BlueRed,
    content: @Composable BoxScope.() -> Unit,
) {
    Row(
        modifier = Modifier
            .background(BackgroundColor.GrayEvent.color)
            .fillMaxSize()
            .padding(
                vertical = VerticalScreenPadding.scaled(),
                horizontal = HorizontalScreenPadding.scaled(),
            ),
    ) {
        Column(
            modifier = Modifier
                .weight(3f)
                .fillMaxHeight()
        ) {
            Tag(data = tag)
            Spacer(modifier = Modifier.height(48.scaledDp()))
            TitleText(
                modifier = Modifier.fillMaxWidth(),
                text = title,
            )
            Spacer(modifier = Modifier.height(24.scaledDp()))
            ContentText(
                modifier = Modifier.fillMaxWidth(),
                text = description,
            )
        }
        Spacer(Modifier.width(64.scaledDp()))
        DoubleFrame(
            modifier = Modifier
                .weight(2f)
                .fillMaxHeight(),
            gradientColor = frameColor,
            content = content
        )
    }
}
