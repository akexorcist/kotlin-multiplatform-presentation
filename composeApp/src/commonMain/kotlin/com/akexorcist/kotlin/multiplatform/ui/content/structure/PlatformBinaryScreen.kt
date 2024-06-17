package com.akexorcist.kotlin.multiplatform.ui.content.structure

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
import com.akexorcist.kotlin.multiplatform.ui.component.template.LargeFrameTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.PlatformTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import kotlinmultiplatform.composeapp.generated.resources.*
import kotlinmultiplatform.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

private val Route = Screen.PlatformBinary.name

fun NavController.navigateToPlatformBinary() {
    navigate(Route)
}

fun NavGraphBuilder.platformBinary() {
    composable(route = Route) {
        PlatformBinaryScreen()
    }
}

@Composable
fun PlatformBinaryScreen() {
    LargeCustomContentTemplate(
        title = "Share code among different platforms",
        description = """
            The Kotlin compiler gets the source code as input and produces a set of platform-specific binaries as a result.
            
            When compiling multiplatform projects, it can produce multiple binaries from the same code.
        """.trimIndent(),
        tag = PlatformTag,
    ) {
        Box(modifier = Modifier.padding(horizontal = 32.dp)) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(Res.drawable.image_platform_binary),
                contentDescription = "Platform binary",
            )
        }
    }
}

@Preview
@Composable
fun PlatformBinaryScreenPreview() {
    MaterialTheme {
        PlatformBinaryScreen()
    }
}
