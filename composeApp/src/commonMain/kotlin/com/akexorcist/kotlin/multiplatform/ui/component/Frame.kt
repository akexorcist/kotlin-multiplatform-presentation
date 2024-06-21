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
import com.akexorcist.kotlin.multiplatform.ui.theme.*

@Composable
private fun frameShape(cornerRadius: Dp) = RoundedCornerShape(cornerRadius)

@Composable
private fun Modifier.frameBorder(cornerRadius: Dp, borderWidth: Dp) = this.border(
    width = borderWidth,
    color = ContentColor.Default.color,
    shape = RoundedCornerShape(cornerRadius),
)

enum class DoubleFrameSize(
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
    size: DoubleFrameSize = DoubleFrameSize.Large,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier = modifier
            .frameBorder(
                cornerRadius = size.cornerRadius.scaled(),
                borderWidth = size.borderWidth.scaled(),
            )
            .clip(frameShape(size.cornerRadius.scaled())),
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(size.spacing.scaled() * 5)
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
                        cornerRadius = size.cornerRadius.scaled(),
                        borderWidth = size.borderWidth.scaled(),
                    )
            )
            Spacer(modifier = Modifier.height(size.spacing.scaled()))
        }

        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .frameBorder(
                        cornerRadius = size.cornerRadius.scaled(),
                        borderWidth = size.borderWidth.scaled(),
                    )
                    .clip(frameShape(size.cornerRadius.scaled()))
                    .background(BackgroundColor.GrayEvent.color)
            ) {
                content()
            }
            Spacer(modifier = Modifier.height(size.spacing.scaled() * 2))
        }
    }
}

private val SingleFrameCornerRadius = 36.dp
private val SingleFrameBorderWidth = 2.dp
private val SingleFrameSpacing = 24.dp

@Composable
fun SingleFrame(
    modifier: Modifier = Modifier,
    gradientColor: GradientColor = GradientColor.BlueRed,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier = modifier
            .frameBorder(
                cornerRadius = SingleFrameCornerRadius.scaled(),
                borderWidth = SingleFrameBorderWidth.scaled(),
            )
            .clip(frameShape(SingleFrameCornerRadius.scaled())),
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(SingleFrameSpacing.scaled() * 5)
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
//        Column(modifier = Modifier.fillMaxSize()) {
//            Spacer(
//                modifier = Modifier
//                    .weight(1f)
//                    .fillMaxWidth()
//                    .frameBorder(
//                        cornerRadius = size.cornerRadius,
//                        borderWidth = size.borderWidth,
//                    )
//            )
//            Spacer(modifier = Modifier.height(size.spacing))
//        }

        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .frameBorder(
                        cornerRadius = SingleFrameCornerRadius.scaled(),
                        borderWidth = SingleFrameBorderWidth.scaled(),
                    )
                    .clip(frameShape(SingleFrameCornerRadius.scaled()))
                    .background(BackgroundColor.GrayEvent.color)
            ) {
                content()
            }
            Spacer(modifier = Modifier.height(SingleFrameSpacing.scaled() * 2))
        }
    }
}
