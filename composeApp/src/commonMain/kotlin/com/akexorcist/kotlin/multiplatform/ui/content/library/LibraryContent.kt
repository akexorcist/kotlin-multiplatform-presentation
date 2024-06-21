package com.akexorcist.kotlin.multiplatform.ui.content.library

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.akexorcist.kotlin.multiplatform.ui.component.ContentText
import com.akexorcist.kotlin.multiplatform.ui.component.LargeContentText
import com.akexorcist.kotlin.multiplatform.ui.extension.gradientTint
import com.akexorcist.kotlin.multiplatform.ui.theme.GradientColor
import com.akexorcist.kotlin.multiplatform.ui.theme.scaledDp

@Composable
internal fun LibraryContent(
    modifier: Modifier,
    type: String,
    name: String,
) {
    Column(modifier = modifier) {
        ContentText(
            modifier = Modifier.gradientTint(GradientColor.BlueRed),
            text = type,
            fontWeight = FontWeight.Medium,
        )
        Spacer(modifier = Modifier.height(4.scaledDp()))
        LargeContentText(
            text = name,
        )
    }
}