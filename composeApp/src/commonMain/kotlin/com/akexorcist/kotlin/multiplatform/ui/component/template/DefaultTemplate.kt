package com.akexorcist.kotlin.multiplatform.ui.component.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.akexorcist.kotlin.multiplatform.ui.component.*
import com.akexorcist.kotlin.multiplatform.ui.theme.BackgroundColor
import com.akexorcist.kotlin.multiplatform.ui.theme.scaled
import com.akexorcist.kotlin.multiplatform.ui.theme.scaledDp

@Composable
fun DefaultTemplate(
    title: String,
    content: String,
    tag: TagData,
) {
    Row(
        modifier = Modifier.background(BackgroundColor.GrayEvent.color),
    ) {
        Column(
            modifier = Modifier
                .weight(3f)
                .fillMaxHeight()
                .padding(
                    vertical = VerticalScreenPadding.scaled(),
                    horizontal = HorizontalScreenPadding.scaled(),
                ),
        ) {
            Tag(data = tag)
            Spacer(modifier = Modifier.height(48.scaledDp()))
            TitleText(
                modifier = Modifier.fillMaxWidth(),
                text = title,
            )
            Spacer(modifier = Modifier.height(32.scaledDp()))
            LargeContentText(
                modifier = Modifier.fillMaxWidth(),
                text = content,
            )
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}
