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

private val Route = Screen.PlatformJvm.name

fun NavController.navigateToPlatformJvm() {
    navigate(Route)
}

fun NavGraphBuilder.platformJvm() {
    composable(route = Route) {
        PlatformJvmScreen()
    }
}

@Composable
fun PlatformJvmScreen() {
    LargeCustomContentTemplate(
        title = "Kotlin/JVM",
        description = """
            Kotlin is a great fit for developing desktop application and server-side applications. 
            
            It allows you to write concise and expressive code while maintaining full compatibility with existing Java-based technology stacks.
        """.trimIndent(),
        tag = PlatformTag,
    ) {
        Box(modifier = Modifier.padding(horizontal = 32.dp)) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(Res.drawable.image_platform_binary_jvm),
                contentDescription = "Platform binary",
            )
        }
    }
}

@Preview
@Composable
fun PlatformJvmScreenPreview() {
    MaterialTheme {
        PlatformJvmScreen()
    }
}
