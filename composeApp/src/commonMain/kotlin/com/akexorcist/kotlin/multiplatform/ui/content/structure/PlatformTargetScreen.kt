package com.akexorcist.kotlin.multiplatform.ui.content.structure

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.RightCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.StructureTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import kotlinmultiplatform.composeapp.generated.resources.*
import kotlinmultiplatform.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

private val Route = Screen.PlatformTarget.name

fun NavController.navigateToPlatformTarget() {
    navigate(Route)
}

fun NavGraphBuilder.platformTarget() {
    composable(route = Route) {
        PlatformTargetScreen()
    }
}

@Composable
fun PlatformTargetScreen() {
    RightCustomContentTemplate(
        title = "Common & Specific Platform Target",
        description = """
            Common code is the Kotlin code shared among different platforms.
            
            And Kotlin Multiplatform allow you to access platform-specific APIs from Kotlin Multiplatform modules.
        """.trimIndent(),
        tag = StructureTag,
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(x = (-72).dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(Res.drawable.image_structure_platform_target),
                contentDescription = "Share piece of logic example",
            )
        }
    }
}

@Preview
@Composable
fun PlatformTargetScreenPreview() {
    MaterialTheme {
        PlatformTargetScreen()
    }
}
