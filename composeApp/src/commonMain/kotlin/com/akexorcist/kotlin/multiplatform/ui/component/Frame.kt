package com.akexorcist.kotlin.multiplatform.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.akexorcist.kotlin.multiplatform.ui.theme.BackgroundColor
import com.akexorcist.kotlin.multiplatform.ui.theme.ContentColor
import com.akexorcist.kotlin.multiplatform.ui.theme.GradientColor

@Composable
private fun frameShape(cornerRadius: Dp) = RoundedCornerShape(cornerRadius)

@Composable
private fun Modifier.frameBorder(cornerRadius: Dp, borderWidth: Dp) = this.border(
    width = borderWidth,
    color = ContentColor.Default.color,
    shape = RoundedCornerShape(cornerRadius),
)

enum class FrameSize(
    val spacing: Dp,
    val cornerRadius: Dp,
    val borderWidth: Dp,
) {
    Large(spacing = 30.dp, cornerRadius = 72.dp, borderWidth = 2.dp),
    Small(spacing = 10.dp, cornerRadius = 12.dp, borderWidth = 1.5.dp),
}

@Composable
fun DoubleFrame(
    modifier: Modifier = Modifier,
    gradientColor: GradientColor = GradientColor.BlueRed,
    size: FrameSize = FrameSize.Large,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier = modifier
            .frameBorder(
                cornerRadius = size.cornerRadius,
                borderWidth = size.borderWidth,
            )
            .clip(frameShape(size.cornerRadius)),
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(size.spacing * 5)
                .align(Alignment.BottomCenter)
                .background(
                    brush = Brush.linearGradient(
                        colorStops = arrayOf(
                            0.1f to gradientColor.from,
                            0.5f to gradientColor.middle,
                            1f to gradientColor.to,
                        ),
                    ),
                )
        )
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .frameBorder(
                        cornerRadius = size.cornerRadius,
                        borderWidth = size.borderWidth,
                    )
            )
            Spacer(modifier = Modifier.height(size.spacing))
        }

        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .frameBorder(
                        cornerRadius = size.cornerRadius,
                        borderWidth = size.borderWidth,
                    )
                    .clip(frameShape(size.cornerRadius))
                    .background(BackgroundColor.Gray.color)
            ) {
                content()
            }
            Spacer(modifier = Modifier.height(size.spacing * 2))
        }
    }
}
