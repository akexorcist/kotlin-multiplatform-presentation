package com.akexorcist.kotlin.multiplatform.ui.component.template

import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.akexorcist.kotlin.multiplatform.ui.component.*
import com.akexorcist.kotlin.multiplatform.ui.theme.BackgroundColor
import com.akexorcist.kotlin.multiplatform.ui.theme.ContentColor
import com.akexorcist.kotlin.multiplatform.ui.theme.GradientColor
import com.akexorcist.kotlin.multiplatform.ui.theme.ThemeColors
import io.kamel.core.Resource
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun ThankYouTemplate(
    title: String,
    name: String,
    position: String,
    profileUrl: String,
    frameColor: GradientColor,
) {
    val resource = asyncPainterResource(profileUrl)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor.GrayEvent.color)
            .padding(
                vertical = VerticalScreenPadding,
                horizontal = HorizontalScreenPadding,
            ),
    ) {
        EventLogo(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset(y = (-24).dp)
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
                        modifier = Modifier.width(120.dp).height(130.dp),
                        size = DoubleFrameSize.Small,
                        gradientColor = frameColor,
                    ) {
                        when (resource) {
                            is Resource.Loading -> {
                                CircularProgressIndicator(
                                    modifier = Modifier
                                        .size(36.dp)
                                        .align(Alignment.Center),
                                    color = ContentColor.Blue.color,
                                )
                            }

                            is Resource.Success -> {
                                KamelImage(
                                    resource = resource,
                                    contentDescription = "profile_image",
                                    contentScale = ContentScale.Crop,
                                    animationSpec = tween(),
                                )
                            }

                            is Resource.Failure -> {}
                        }
                    }
                    Spacer(modifier = Modifier.width(32.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            modifier = Modifier.offset(x = 4.dp),
                            text = name,
                            fontSize = MaterialTheme.typography.h5.fontSize,
                            color = ThemeColors.TextPrimary,
                            fontStyle = MaterialTheme.typography.h5.fontStyle,
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = MaterialTheme.typography.h5.letterSpacing,
                            lineHeight = MaterialTheme.typography.h5.lineHeight,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            modifier = Modifier.offset(x = 4.dp),
                            text = position,
                            fontSize = MaterialTheme.typography.h5.fontSize,
                            color = ThemeColors.TextPrimary,
                            fontStyle = MaterialTheme.typography.h5.fontStyle,
                            fontWeight = FontWeight.Normal,
                            letterSpacing = MaterialTheme.typography.h5.letterSpacing,
                            lineHeight = MaterialTheme.typography.h5.lineHeight,
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
