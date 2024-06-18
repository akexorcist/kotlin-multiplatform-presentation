package com.akexorcist.kotlin.multiplatform.ui.content.platform

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.LargeCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.PlatformTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import kotlinmultiplatform.composeapp.generated.resources.*
import kotlinmultiplatform.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

private val Route = Screen.PlatformNative.name

fun NavController.navigateToPlatformNative() {
    navigate(Route)
}

fun NavGraphBuilder.platformNative() {
    composable(route = Route) {
        PlatformNativeScreen()
    }
}

@Composable
fun PlatformNativeScreen() {
    LargeCustomContentTemplate(
        title = "Kotlin/Native",
        description = """
            Compiling Kotlin code to native binaries which can run without a virtual machine.
            
            Kotlin/Native is primarily designed to allow compilation for platforms on which virtual machines are not desirable or possible, such as embedded devices or iOS.
        """.trimIndent(),
        tag = PlatformTag,
    ) {
        Box(modifier = Modifier.padding(horizontal = 32.dp)) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(Res.drawable.image_platform_binary_native),
                contentDescription = "Platform binary",
            )
        }
    }
}

@Preview
@Composable
fun PlatformNativeScreenPreview() {
    MaterialTheme {
        PlatformNativeScreen()
    }
}
