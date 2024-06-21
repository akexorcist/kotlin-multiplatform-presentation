package com.akexorcist.kotlin.multiplatform.ui.content.adoption

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.RightCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.AdoptionTag
import com.akexorcist.kotlin.multiplatform.ui.content.camera.ViewFinder
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen

private val Route = Screen.CameraAccess.name

fun NavController.navigateToCameraAccess() {
    navigate(Route)
}

fun NavGraphBuilder.cameraAccess() {
    composable(route = Route) {
        CameraAccessScreen()
    }
}

@Composable
fun CameraAccessScreen() {
    RightCustomContentTemplate(
        title = "Camera Access",
        description = """
            ✅ Android
            ✅ iOS
            ✅ Desktop
            ✅ Web
        """.trimIndent(),
        tag = AdoptionTag,
        content = { ViewFinder(modifier = Modifier.fillMaxSize()) },
    )
}

@Preview
@Composable
fun CameraAccessScreenPreview() {
    MaterialTheme {
        CameraAccessScreen()
    }
}
