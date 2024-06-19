package com.akexorcist.kotlin.multiplatform.ui.content.adoption

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.TagData
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultTemplate
import com.akexorcist.kotlin.multiplatform.ui.component.template.RightCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.AdoptionTag
import com.akexorcist.kotlin.multiplatform.ui.content.camera.ViewFinder
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.GradientColor

private val Route = Screen.CameraAccess1.name

fun NavController.navigateToCameraAccess1() {
    navigate(Route)
}

fun NavGraphBuilder.cameraAccess1() {
    composable(route = Route) {
        CameraAccess1Screen()
    }
}

@Composable
fun CameraAccess1Screen() {
    RightCustomContentTemplate(
        title = "Camera Access",
        description = "",
        tag = AdoptionTag,
        content = { ViewFinder(modifier = Modifier.fillMaxSize()) },
    )
}

@Preview
@Composable
fun CameraAccess1ScreenPreview() {
    MaterialTheme {
        CameraAccess1Screen()
    }
}
