package com.akexorcist.kotlin.multiplatform.ui.content.introduction

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.RightCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.IntroductionTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.scaledDp
import kotlinmultiplatform.composeapp.generated.resources.*
import kotlinmultiplatform.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

private val Route = Screen.PlatformSupport.name

fun NavController.navigateToPlatformSupport() {
    navigate(Route)
}

fun NavGraphBuilder.platformSupport() {
    composable(route = Route) {
        PlatformSupportScreen()
    }
}

@Composable
fun PlatformSupportScreen() {
    RightCustomContentTemplate(
        title = "Supported Platforms",
        description = """
            Kotlin Multiplatform is a technology that allows you to create applications for various platforms and efficiently reuse code across them while retaining the benefits of native programming.
            
            • Desktop (Linux, macOS, Windows)
            • Mobile (Android & iOS)
            • Web
            • Server
        """.trimIndent(),
        tag = IntroductionTag,
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(x = (-72).scaledDp()),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier.weight(4f),
                painter = painterResource(Res.drawable.image_platform_support),
                contentDescription = "Kotlin Multiplatform",
                contentScale = ContentScale.FillWidth,
            )
        }
    }
}

@Preview
@Composable
fun PlatformSupportScreenPreview() {
    MaterialTheme {
        PlatformSupportScreen()
    }
}
