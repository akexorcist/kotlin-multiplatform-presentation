package com.akexorcist.kotlin.multiplatform.ui.content.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
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
import kotlinmultiplatform.composeapp.generated.resources.ic_compose_multiplatform_desktop
import org.jetbrains.compose.resources.painterResource

private val Route = Screen.ComposeMultiplatformRender.name

fun NavController.navigateToComposeMultiplatformRender() {
    navigate(Route)
}

fun NavGraphBuilder.composeMultiplatformRender() {
    composable(route = Route) {
        ComposeMultiplatformRenderScreen()
    }
}

@Composable
fun ComposeMultiplatformRenderScreen() {
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
                            modifier = Modifier.height(120.dp),
                            painter = painterResource(Res.drawable.ic_skia),
                            contentDescription = "Skia",
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        LargeContentText(
                            modifier = Modifier.wrapContentHeight(),
                            text = "Skia",
                            fontWeight = FontWeight.Bold,
                            alignment = TextAlign.Center,
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        SmallContentText(
                            modifier = Modifier.wrapContentHeight(),
                            text = "Open source 2D graphics library",
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
                                .height(120.dp)
                                .offset(x = 4.dp),
                            painter = painterResource(Res.drawable.ic_kotlin_logo_only),
                            contentDescription = "Desktop",
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        LargeContentText(
                            modifier = Modifier.wrapContentHeight(),
                            text = "Skiko",
                            fontWeight = FontWeight.Bold,
                            alignment = TextAlign.Center,
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        SmallContentText(
                            modifier = Modifier.wrapContentHeight(),
                            text = "Kotlin Multiplatform bindings to Skia",
                            alignment = TextAlign.Center,
                        )
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
fun ComposeMultiplatformRenderScreenPreview() {
    MaterialTheme {
        ComposeMultiplatformRenderScreen()
    }
}
