package com.akexorcist.kotlin.multiplatform.ui.content.ide

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.ContentText
import com.akexorcist.kotlin.multiplatform.ui.component.SmallContentText
import com.akexorcist.kotlin.multiplatform.ui.component.template.CustomContentItem
import com.akexorcist.kotlin.multiplatform.ui.component.template.MultipleCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.IdeTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
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
                        Spacer(modifier = Modifier.height(64.dp))
                        Image(
                            modifier = Modifier.size(200.dp),
                            painter = painterResource(Res.drawable.ic_ide_android_studio),
                            contentDescription = "Android Studio",
                            contentScale = ContentScale.Fit,
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        ContentText(
                            modifier = Modifier.wrapContentHeight(),
                            text = "Android Studio",
                            fontWeight = FontWeight.Bold,
                        )
                        SmallContentText(
                            modifier = Modifier.wrapContentHeight(),
                            text = "(Google)",
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
                        Spacer(modifier = Modifier.height(64.dp))
                        Image(
                            modifier = Modifier.size(200.dp),
                            painter = painterResource(Res.drawable.ic_ide_intellij),
                            contentDescription = "IntelliJ IDEA",
                            contentScale = ContentScale.Fit,
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        ContentText(
                            modifier = Modifier.wrapContentHeight(),
                            text = "IntelliJ IDEA",
                            fontWeight = FontWeight.Bold,
                        )
                        SmallContentText(
                            modifier = Modifier.wrapContentHeight(),
                            text = "(JetBrains)",
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
                        Spacer(modifier = Modifier.height(64.dp))
                        Image(
                            modifier = Modifier.size(200.dp),
                            painter = painterResource(Res.drawable.ic_ide_fleet),
                            contentDescription = "Fleet",
                            contentScale = ContentScale.Fit,
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        ContentText(
                            modifier = Modifier.wrapContentHeight(),
                            text = "Fleet",
                            fontWeight = FontWeight.Bold,
                        )
                        SmallContentText(
                            modifier = Modifier.wrapContentHeight(),
                            text = "(JetBrains)",
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
        tag = IdeTag,
    )
}

@Preview
@Composable
fun IdeForKotlinMultiplatformScreenPreview() {
    MaterialTheme {
        IdeForKotlinMultiplatformScreen()
    }
}
