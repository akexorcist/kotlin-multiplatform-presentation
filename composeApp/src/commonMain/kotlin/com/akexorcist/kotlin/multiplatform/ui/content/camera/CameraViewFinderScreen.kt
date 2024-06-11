package com.akexorcist.kotlin.multiplatform.ui.content.camera

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.TagData
import com.akexorcist.kotlin.multiplatform.ui.component.template.RightCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.BackgroundColor
import com.akexorcist.kotlin.multiplatform.ui.theme.GradientColor
import org.jetbrains.compose.ui.tooling.preview.Preview

private val Route = Screen.CameraViewFinder.name

fun NavController.navigateToCameraViewFinder() {
    navigate(Route)
}

fun NavGraphBuilder.cameraViewFinder() {
    composable(route = Route) {
        CameraViewFinderScreen()
    }
}

@Composable
fun CameraViewFinderScreen() {
    RightCustomContentTemplate(
        title = "Camera Showcase",
        description = "",
        tag = TagData(
            text = "Camera",
            background = GradientColor.BlueRed
        ),
        content = { ViewFinder(modifier = Modifier.fillMaxSize()) },
    )
}

@Composable
fun ViewFinder(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.background(BackgroundColor.GrayEvent.color),
        contentAlignment = Alignment.Center,
    ) {
        CameraPreview()
    }
}

@Preview
@Composable
fun CameraViewFinderScreenPreview() {
    MaterialTheme {
        CameraViewFinderScreen()
    }
}
