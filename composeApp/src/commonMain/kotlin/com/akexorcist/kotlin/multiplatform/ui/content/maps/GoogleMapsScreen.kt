package com.akexorcist.kotlin.multiplatform.ui.content.maps

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.CustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import org.jetbrains.compose.ui.tooling.preview.Preview

private val Route = Screen.GoogleMaps.name

fun NavController.navigateToGoogleMaps() {
    navigate(Route)
}

fun NavGraphBuilder.googleMaps() {
    composable(route = Route) {
        GoogleMapsScreen()
    }
}

@Composable
fun GoogleMapsScreen() {
    CustomContentTemplate(
        title = "Google Maps Showcase",
        content = "",
        custom = { GoogleMapsContent(modifier = Modifier.fillMaxSize()) },
    )
}

@Preview
@Composable
fun GoogleMapsScreenPreview() {
    MaterialTheme {
        GoogleMapsScreen()
    }
}
