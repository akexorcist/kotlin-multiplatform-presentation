package com.akexorcist.kotlin.multiplatform.ui.content.tools

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.ContentText
import com.akexorcist.kotlin.multiplatform.ui.component.SmallContentText
import com.akexorcist.kotlin.multiplatform.ui.component.template.CustomContentItem
import com.akexorcist.kotlin.multiplatform.ui.component.template.MultipleCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.ToolsTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.scaled
import com.akexorcist.kotlin.multiplatform.ui.theme.scaledDp
import kotlinmultiplatform.composeapp.generated.resources.*
import kotlinmultiplatform.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

private val Route = Screen.IdeForKotlinMultiplatform.name

fun NavController.navigateToIdeForKotlinMultiplatform() {
    navigate(Route)
}

fun NavGraphBuilder.ideForKotlinMultiplatform() {
    composable(route = Route) {
        IdeForKotlinMultiplatformScreen()
    }
}

@Composable
fun IdeForKotlinMultiplatformScreen() {
    MultipleCustomContentTemplate(
        contents = listOf(
            CustomContentItem(
                weight = 0.5f,
                title = "",
                description = "",
                content = {},
            ),
            CustomContentItem(
                weight = 1f,
                title = "",
                description = "",
                content = {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Spacer(modifier = Modifier.height(64.scaledDp()))
                        Image(
                            modifier = Modifier.size(200.scaledDp()),
                            painter = painterResource(Res.drawable.ic_ide_android_studio),
                            contentDescription = "Android Studio",
                            contentScale = ContentScale.Fit,
                        )
                        Spacer(modifier = Modifier.height(32.scaledDp()))
                        ContentText(
                            modifier = Modifier.wrapContentHeight(),
                            text = "Android Studio",
                            fontWeight = FontWeight.Bold,
                            alignment = TextAlign.Center,
                        )
                        ContentText(
                            modifier = Modifier.wrapContentHeight(),
                            text = "(Google)",
                            alignment = TextAlign.Center,
                        )
                    }
                },
            ),
            CustomContentItem(
                weight = 1f,
                title = "",
                description = "",
                content = {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Spacer(modifier = Modifier.height(64.scaledDp()))
                        Image(
                            modifier = Modifier.size(200.scaledDp()),
                            painter = painterResource(Res.drawable.ic_ide_intellij),
                            contentDescription = "IntelliJ IDEA",
                            contentScale = ContentScale.Fit,
                        )
                        Spacer(modifier = Modifier.height(32.scaledDp()))
                        ContentText(
                            modifier = Modifier.wrapContentHeight(),
                            text = "IntelliJ IDEA",
                            fontWeight = FontWeight.Bold,
                            alignment = TextAlign.Center,
                        )
                        SmallContentText(
                            modifier = Modifier.wrapContentHeight(),
                            text = "(JetBrains)",
                            alignment = TextAlign.Center,
                        )
                    }
                },
            ),
            CustomContentItem(
                weight = 1f,
                title = "",
                description = "",
                content = {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Spacer(modifier = Modifier.height(64.scaledDp()))
                        Image(
                            modifier = Modifier.size(200.scaledDp()),
                            painter = painterResource(Res.drawable.ic_ide_fleet),
                            contentDescription = "Fleet",
                            contentScale = ContentScale.Fit,
                        )
                        Spacer(modifier = Modifier.height(32.scaledDp()))
                        ContentText(
                            modifier = Modifier.wrapContentHeight(),
                            text = "Fleet",
                            fontWeight = FontWeight.Bold,
                            alignment = TextAlign.Center,
                        )
                        SmallContentText(
                            modifier = Modifier.wrapContentHeight(),
                            text = "(JetBrains)",
                            alignment = TextAlign.Center,
                        )
                    }
                },
            ),
            CustomContentItem(
                weight = 0.5f,
                title = "",
                description = "",
                content = {},
            ),
        ),
        tag = ToolsTag,
    )
}

@Preview
@Composable
fun IdeForKotlinMultiplatformScreenPreview() {
    MaterialTheme {
        IdeForKotlinMultiplatformScreen()
    }
}
