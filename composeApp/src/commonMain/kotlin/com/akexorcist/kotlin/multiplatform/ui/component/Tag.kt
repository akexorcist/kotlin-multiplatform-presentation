package com.akexorcist.kotlin.multiplatform.ui.component

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.akexorcist.kotlin.multiplatform.ui.extension.px
import com.akexorcist.kotlin.multiplatform.ui.theme.GradientColor
import com.akexorcist.kotlin.multiplatform.ui.theme.ThemeColors

data class TagData(
    val text: String,
    val background: GradientColor,
)

private val TagWidth = 280.dp
private val TagHeight = 72.dp

@Composable
fun Tag(data: TagData) {
    val infiniteTransition = rememberInfiniteTransition(label = "background_color")
    val backgroundColorOffsetX by infiniteTransition.animateFloat(
        initialValue = TagWidth.px(),
        targetValue = TagWidth.px() * 3,
        animationSpec = infiniteRepeatable(
            animation = TweenSpec(
                durationMillis = 3750,
                easing = LinearEasing,
            )
        )
    )
    Box(
        modifier = Modifier
            .width(TagWidth)
            .height(TagHeight)
            .background(
                brush = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to data.background.to,
                        0.125f to data.background.middle,
                        0.25f to data.background.from,
                        0.375f to data.background.middle,
                        0.5f to data.background.to,
                        0.625f to data.background.middle,
                        0.75f to data.background.from,
                        0.875f to data.background.middle,
                        1f to data.background.to,
                    ),
                    start = Offset(backgroundColorOffsetX - (TagWidth.px() * 4), 0f),
                    end = Offset(backgroundColorOffsetX, 0f),
                ),
                shape = RoundedCornerShape(100),
            )
            .border(
                width = 2.dp,
                color = ThemeColors.BorderPrimary,
                shape = RoundedCornerShape(100),
            )
            .padding(horizontal = 48.dp, vertical = 16.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = data.text,
            fontSize = MaterialTheme.typography.h5.fontSize,
            color = ThemeColors.TextPrimary,
            fontStyle = MaterialTheme.typography.h5.fontStyle,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = MaterialTheme.typography.h5.letterSpacing,
            lineHeight = MaterialTheme.typography.h5.lineHeight,
        )
    }
}
