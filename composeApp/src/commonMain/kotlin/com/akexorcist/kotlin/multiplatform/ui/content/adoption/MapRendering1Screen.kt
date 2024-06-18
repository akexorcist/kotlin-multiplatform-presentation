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

private val Route = Screen.MapRendering1.name

fun NavController.navigateToMapRendering1() {
    navigate(Route)
}

fun NavGraphBuilder.mapRendering1() {
    composable(route = Route) {
        MapRendering1Screen()
    }
}

@Composable
fun MapRendering1Screen() {
    DefaultTemplate(
        title = "Map Rendering 1",
        content = "",
        tag = AdoptionTag,
    )
}

@Preview
@Composable
fun MapRendering1ScreenPreview() {
    MaterialTheme {
        MapRendering1Screen()
    }
}
