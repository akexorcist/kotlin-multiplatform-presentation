package com.akexorcist.kotlin.multiplatform.ui.content.adoption

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.AdoptionTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen

private val Route = Screen.CameraAccess2.name

fun NavController.navigateToCameraAccess2() {
    navigate(Route)
}

fun NavGraphBuilder.cameraAccess2() {
    composable(route = Route) {
        CameraAccess2Screen()
    }
}

@Composable
fun CameraAccess2Screen() {
    DefaultTemplate(
        title = "Camera Access 2",
        content = "",
        tag = AdoptionTag,
    )
}

@Preview
@Composable
fun CameraAccess2ScreenPreview() {
    MaterialTheme {
        CameraAccess2Screen()
    }
}
