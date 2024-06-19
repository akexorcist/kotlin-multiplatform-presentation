package com.akexorcist.kotlin.multiplatform.ui.component.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.akexorcist.kotlin.multiplatform.ui.component.*
import com.akexorcist.kotlin.multiplatform.ui.theme.BackgroundColor

@Composable
fun DefaultCustomContentTemplate(
    title: String,
    tag: TagData,
    content: @Composable () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor.GrayEvent.color)
            .padding(
                vertical = VerticalScreenPadding,
                horizontal = HorizontalScreenPadding,
            ),
    ) {
        Tag(data = tag)
        Spacer(modifier = Modifier.height(48.dp))
        TitleText(
            modifier = Modifier.fillMaxWidth(),
            text = title,
        )
        Spacer(modifier = Modifier.height(32.dp))
        content()
    }
}
