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
    DefaultTemplate(
        title = "Camera Access 1",
        content = "",
        tag = AdoptionTag,
    )
}

@Preview
@Composable
fun CameraAccess1ScreenPreview() {
    MaterialTheme {
        CameraAccess1Screen()
    }
}
