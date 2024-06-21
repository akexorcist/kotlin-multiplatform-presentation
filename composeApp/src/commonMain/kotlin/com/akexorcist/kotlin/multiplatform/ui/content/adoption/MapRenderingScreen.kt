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
import com.akexorcist.kotlin.multiplatform.ui.content.maps.MapContent
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen

private val Route = Screen.MapRendering.name

fun NavController.navigateToMapRendering1() {
    navigate(Route)
}

fun NavGraphBuilder.mapRendering() {
    composable(route = Route) {
        MapRenderingScreen()
    }
}

@Composable
fun MapRenderingScreen() {
    RightCustomContentTemplate(
        title = "Display Map",
        description = """
            ✅ Android
            ✅ iOS
            ✅ Desktop
            ❌ Web
        """.trimIndent(),
        tag = AdoptionTag,
        content = { MapContent(modifier = Modifier.fillMaxSize()) },
    )
}

@Preview
@Composable
fun MapRenderingScreenPreview() {
    MaterialTheme {
        MapRenderingScreen()
    }
}
