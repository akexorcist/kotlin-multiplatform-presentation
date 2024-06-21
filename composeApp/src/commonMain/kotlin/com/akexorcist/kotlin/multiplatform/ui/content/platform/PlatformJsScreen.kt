package com.akexorcist.kotlin.multiplatform.ui.content.platform

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.LargeCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.PlatformTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.scaledDp
import kotlinmultiplatform.composeapp.generated.resources.*
import kotlinmultiplatform.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

private val Route = Screen.PlatformJs.name

fun NavController.navigateToPlatformJs() {
    navigate(Route)
}

fun NavGraphBuilder.platformJs() {
    composable(route = Route) {
        PlatformJsScreen()
    }
}

@Composable
fun PlatformJsScreen() {
    LargeCustomContentTemplate(
        title = "Kotlin/JS",
        description = """
            Kotlin/JS provides the ability to transpile your Kotlin code, the Kotlin standard library, and any compatible dependencies to JavaScript.
            
            The current implementation of Kotlin/JS targets ES5.
        """.trimIndent(),
        tag = PlatformTag,
    ) {
        Box(modifier = Modifier.padding(horizontal = 32.scaledDp())) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(Res.drawable.image_platform_binary_js),
                contentDescription = "Platform binary",
            )
        }
    }
}

@Preview
@Composable
fun PlatformJsScreenPreview() {
    MaterialTheme {
        PlatformJsScreen()
    }
}
