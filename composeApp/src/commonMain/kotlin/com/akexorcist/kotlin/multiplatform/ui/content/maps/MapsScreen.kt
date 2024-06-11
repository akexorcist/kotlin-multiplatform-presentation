package com.akexorcist.kotlin.multiplatform.ui.content.maps

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.TagData
import com.akexorcist.kotlin.multiplatform.ui.component.template.RightCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.GradientColor
import org.jetbrains.compose.ui.tooling.preview.Preview

private val Route = Screen.Map.name

fun NavController.navigateToMap() {
    navigate(Route)
}

fun NavGraphBuilder.map() {
    composable(route = Route) {
        MapScreen()
    }
}

@Composable
fun MapScreen() {
    RightCustomContentTemplate(
        title = "Map Showcase",
        description = "",
        tag = TagData(
            text = "Camera",
            background = GradientColor.BlueRed
        ),
        content = { MapContent(modifier = Modifier.fillMaxSize()) },
    )
}

@Preview
@Composable
fun MapScreenPreview() {
    MaterialTheme {
        MapScreen()
    }
}
