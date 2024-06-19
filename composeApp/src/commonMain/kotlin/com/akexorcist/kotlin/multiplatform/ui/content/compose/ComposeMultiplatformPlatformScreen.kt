package com.akexorcist.kotlin.multiplatform.ui.content.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.ContentText
import com.akexorcist.kotlin.multiplatform.ui.component.LargeContentText
import com.akexorcist.kotlin.multiplatform.ui.component.SmallContentText
import com.akexorcist.kotlin.multiplatform.ui.component.template.CustomContentItem
import com.akexorcist.kotlin.multiplatform.ui.component.template.MultipleCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.ComposeTag
import com.akexorcist.kotlin.multiplatform.ui.extension.gradientTint
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.BackgroundColor
import com.akexorcist.kotlin.multiplatform.ui.theme.ContentColor
import com.akexorcist.kotlin.multiplatform.ui.theme.GradientColor
import kotlinmultiplatform.composeapp.generated.resources.*
import kotlinmultiplatform.composeapp.generated.resources.Res
import kotlinmultiplatform.composeapp.generated.resources.image_share_code_strategy_partial_logic
import org.jetbrains.compose.resources.painterResource

private val Route = Screen.ComposeMultiplatformPlatform.name

fun NavController.navigateToComposeMultiplatformPlatform() {
    navigate(Route)
}

fun NavGraphBuilder.composeMultiplatformPlatform() {
    composable(route = Route) {
        ComposeMultiplatformPlatformScreen()
    }
}

@Composable
fun ComposeMultiplatformPlatformScreen() {
    MultipleCustomContentTemplate(
        contents = listOf(
            CustomContentItem(
                title = "",
                description = "",
                content = {},
                weight = 0.25f,
            ),
            CustomContentItem(
                title = "",
                description = "",
                content = {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Spacer(modifier = Modifier.height(64.dp))
                        Image(
                            modifier = Modifier
                                .size(160.dp)
                                .gradientTint(GradientColor.BlueRed),
                            painter = painterResource(Res.drawable.ic_compose_multiplatform_android),
                            contentDescription = "Android",
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        LargeContentText(
                            modifier = Modifier.wrapContentHeight(),
                            text = "Android",
                            fontWeight = FontWeight.Bold,
                            alignment = TextAlign.Center,
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        SmallContentText(
                            modifier = Modifier.wrapContentHeight(),
                            text = "via Jetpack Compose",
                            alignment = TextAlign.Center,
                        )
                    }
                },
            ),
            CustomContentItem(
                title = "",
                description = "",
                content = {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Spacer(modifier = Modifier.height(64.dp))
                        Image(
                            modifier = Modifier
                                .size(160.dp)
                                .gradientTint(GradientColor.BlueRed),
                            painter = painterResource(Res.drawable.ic_compose_multiplatform_desktop),
                            contentDescription = "Desktop",
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        LargeContentText(
                            modifier = Modifier.wrapContentHeight(),
                            text = "Desktop",
                            fontWeight = FontWeight.Bold,
                            alignment = TextAlign.Center,
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        SmallContentText(
                            modifier = Modifier.wrapContentHeight(),
                            text = "Windows, MacOS, Linux",
                            alignment = TextAlign.Center,
                        )
                    }
                },
            ),
            CustomContentItem(
                title = "",
                description = "",
                content = {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Spacer(modifier = Modifier.height(64.dp))
                        Image(
                            modifier = Modifier
                                .size(160.dp)
                                .gradientTint(GradientColor.BlueRed),
                            painter = painterResource(Res.drawable.ic_compose_multiplatform_ios),
                            contentDescription = "iOS",
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        LargeContentText(
                            modifier = Modifier.wrapContentHeight(),
                            text = "iOS",
                            fontWeight = FontWeight.Bold,
                            alignment = TextAlign.Center,
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Box(
                            modifier = Modifier
                                .height(48.dp)
                                .background(
                                    color = BackgroundColor.Code.color.copy(alpha = 0.85f),
                                    shape = RoundedCornerShape(8.dp),
                                )
                                .padding(horizontal = 16.dp),
                            contentAlignment = Alignment.Center,
                        ) {
                            SmallContentText(
                                modifier = Modifier.wrapContentHeight(),
                                text = "Beta",
                                color = ContentColor.White,
                                alignment = TextAlign.Center,
                            )
                        }
                    }
                },
            ),
            CustomContentItem(
                title = "",
                description = "",
                content = {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Spacer(modifier = Modifier.height(64.dp))
                        Image(
                            modifier = Modifier
                                .size(160.dp)
                                .gradientTint(GradientColor.BlueRed),
                            painter = painterResource(Res.drawable.ic_compose_multiplatform_web),
                            contentDescription = "Web",
                            contentScale = ContentScale.Fit,
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        LargeContentText(
                            modifier = Modifier.wrapContentHeight(),
                            text = "Web",
                            fontWeight = FontWeight.Bold,
                            alignment = TextAlign.Center,
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Box(
                            modifier = Modifier
                                .height(48.dp)
                                .background(
                                    color = BackgroundColor.Code.color.copy(alpha = 0.85f),
                                    shape = RoundedCornerShape(8.dp),
                                )
                                .padding(horizontal = 16.dp),
                            contentAlignment = Alignment.Center,
                        ) {
                            SmallContentText(
                                modifier = Modifier.wrapContentHeight(),
                                text = "Alpha",
                                color = ContentColor.White,
                                alignment = TextAlign.Center,
                            )
                        }
                    }
                },
            ),
            CustomContentItem(
                title = "",
                description = "",
                content = {},
                weight = 0.25f,
            ),
        ),
        tag = ComposeTag,
    )
}

@Preview
@Composable
fun ComposeMultiplatformPlatformScreenPreview() {
    MaterialTheme {
        ComposeMultiplatformPlatformScreen()
    }
}
