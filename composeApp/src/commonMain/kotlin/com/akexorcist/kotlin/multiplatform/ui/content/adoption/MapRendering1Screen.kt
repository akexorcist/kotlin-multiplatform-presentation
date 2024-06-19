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
import com.akexorcist.kotlin.multiplatform.ui.content.maps.MapContent
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.GradientColor

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
    RightCustomContentTemplate(
        title = "Display Map",
        description = "",
        tag = AdoptionTag,
        content = { MapContent(modifier = Modifier.fillMaxSize()) },
    )
}

@Preview
@Composable
fun MapRendering1ScreenPreview() {
    MaterialTheme {
        MapRendering1Screen()
    }
}
