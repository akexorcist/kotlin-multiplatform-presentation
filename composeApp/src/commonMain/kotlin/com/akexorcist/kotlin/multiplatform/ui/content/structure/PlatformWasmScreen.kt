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
import com.akexorcist.kotlin.multiplatform.ui.content.PlatformTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import kotlinmultiplatform.composeapp.generated.resources.*
import kotlinmultiplatform.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

private val Route = Screen.PlatformWasm.name

fun NavController.navigateToPlatformWasm() {
    navigate(Route)
}

fun NavGraphBuilder.platformWasm() {
    composable(route = Route) {
        PlatformWasmScreen()
    }
}

@Composable
fun PlatformWasmScreen() {
    LargeCustomContentTemplate(
        title = "Kotlin/Wasm",
        description = """
            Build applications and reuse mobile and desktop user interfaces (UIs) in your web projects through Compose Multiplatform and Kotlin/Wasm.
            
            Specifically for web platforms, Compose Multiplatform uses Kotlin/Wasm as its compilation target.
        """.trimIndent(),
        tag = PlatformTag,
    ) {
        Box(modifier = Modifier.padding(horizontal = 32.dp)) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(Res.drawable.image_platform_binary_wasm),
                contentDescription = "Platform binary",
            )
        }
    }
}

@Preview
@Composable
fun PlatformWasmScreenPreview() {
    MaterialTheme {
        PlatformWasmScreen()
    }
}
