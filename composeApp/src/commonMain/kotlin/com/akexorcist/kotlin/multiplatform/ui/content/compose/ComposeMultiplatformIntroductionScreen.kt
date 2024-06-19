package com.akexorcist.kotlin.multiplatform.ui.content.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.LargeFrameTemplate
import com.akexorcist.kotlin.multiplatform.ui.component.template.RightFrameTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.ComposeTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.GradientColor
import kotlinmultiplatform.composeapp.generated.resources.Res
import kotlinmultiplatform.composeapp.generated.resources.image_compose_multiplatform
import kotlinmultiplatform.composeapp.generated.resources.image_project_structure_module
import org.jetbrains.compose.resources.painterResource

private val Route = Screen.ComposeMultiplatformIntroduction.name

fun NavController.navigateToComposeMultiplatformIntroduction() {
    navigate(Route)
}

fun NavGraphBuilder.composeMultiplatformIntroduction() {
    composable(route = Route) {
        ComposeMultiplatformIntroductionScreen()
    }
}

@Composable
fun ComposeMultiplatformIntroductionScreen() {
    LargeFrameTemplate(
        title = "Compose Multiplatform",
        description = "Declarative framework for sharing UIs across multiple platforms. Based on Kotlin and Jetpack Compose.",
        tag = ComposeTag,
        frameColor = GradientColor.BlueRed,
    ) {
        Image(
            modifier = Modifier.fillMaxSize().background(color = Color(0xFF2B2D30)),
            painter = painterResource(Res.drawable.image_compose_multiplatform),
            contentDescription = "Compose Multiplatform",
            contentScale = ContentScale.Crop,
        )
    }
}

@Preview
@Composable
fun ComposeMultiplatformIntroductionScreenPreview() {
    MaterialTheme {
        ComposeMultiplatformIntroductionScreen()
    }
}
