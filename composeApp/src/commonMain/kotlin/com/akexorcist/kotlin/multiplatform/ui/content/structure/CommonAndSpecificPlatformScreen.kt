package com.akexorcist.kotlin.multiplatform.ui.content.structure

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.RightCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.StructureTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.scaledDp
import kotlinmultiplatform.composeapp.generated.resources.*
import kotlinmultiplatform.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

private val Route = Screen.CommonAndSpecificPlatform.name

fun NavController.navigateToCommonAndSpecificPlatform() {
    navigate(Route)
}

fun NavGraphBuilder.commonAndSpecificPlatform() {
    composable(route = Route) {
        CommonAndSpecificPlatformScreen()
    }
}

@Composable
fun CommonAndSpecificPlatformScreen() {
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
                .offset(x = (-72).scaledDp()),
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
fun CommonAndSpecificPlatformScreenPreview() {
    MaterialTheme {
        CommonAndSpecificPlatformScreen()
    }
}
