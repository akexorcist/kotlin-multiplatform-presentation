package com.akexorcist.kotlin.multiplatform.ui.component.template

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import com.akexorcist.kotlin.multiplatform.ui.component.*
import com.akexorcist.kotlin.multiplatform.ui.theme.*
import kotlinmultiplatform.composeapp.generated.resources.Res
import kotlinmultiplatform.composeapp.generated.resources.image_speaker_profile
import org.jetbrains.compose.resources.painterResource

@Composable
fun ThankYouTemplate(
    title: String,
    name: String,
    position: String,
    frameColor: GradientColor,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor.GrayEvent.color)
            .padding(
                vertical = VerticalScreenPadding.scaled(),
                horizontal = HorizontalScreenPadding.scaled(),
            ),
    ) {
        EventLogo(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset(y = (-24).scaledDp())
        )
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = title,
                    fontSize = MaterialTheme.typography.h1.fontSize,
                    color = ThemeColors.TextPrimary,
                    fontStyle = MaterialTheme.typography.h1.fontStyle,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = MaterialTheme.typography.h1.letterSpacing,
                    lineHeight = MaterialTheme.typography.h1.lineHeight,
                )
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    DoubleFrame(
                        modifier = Modifier.width(120.scaledDp()).height(130.scaledDp()),
                        size = DoubleFrameSize.Small,
                        gradientColor = frameColor,
                    ) {
                        Image(
                            modifier = Modifier.fillMaxSize(),
                            painter = painterResource(Res.drawable.image_speaker_profile),
                            contentDescription = "Speaker",
                            contentScale = ContentScale.Crop,
                        )
                    }
                    Spacer(modifier = Modifier.width(32.scaledDp()))
                    Column {
                        ContentText(
                            text = name,
                            fontWeight = FontWeight.SemiBold,
                        )
                        Spacer(modifier = Modifier.height(8.scaledDp()))
                        Box(
                            modifier = Modifier
                                .border(
                                    width = 1.5.scaledDp(),
                                    color = ContentColor.Default.color,
                                    shape = RoundedCornerShape(100),
                                )
                                .background(
                                    color = BackgroundColor.White.color,
                                    shape = RoundedCornerShape(100),
                                )
                                .padding(
                                    horizontal = 24.scaledDp(),
                                    vertical = 4.scaledDp(),
                                ),
                            contentAlignment = Alignment.Center,
                        ) {
                            SmallContentText(
                                modifier = Modifier.offset(y = (-2).scaledDp()),
                                text = position,
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(32.scaledDp()))
        }
    }
}
