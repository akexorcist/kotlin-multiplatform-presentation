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

private val Route = Screen.MapRendering2.name

fun NavController.navigateToMapRendering2() {
    navigate(Route)
}

fun NavGraphBuilder.mapRendering2() {
    composable(route = Route) {
        MapRendering2Screen()
    }
}

@Composable
fun MapRendering2Screen() {
    DefaultTemplate(
        title = "Map Rendering 2",
        content = "",
        tag = AdoptionTag,
    )
}

@Preview
@Composable
fun MapRendering2ScreenPreview() {
    MaterialTheme {
        MapRendering2Screen()
    }
}
