package com.akexorcist.kotlin.multiplatform.ui.content.cover

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.TitleTemplate
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen

private val Route = Screen.Cover.name

fun NavController.navigateToCover() {
    navigate(Route)
}

fun NavGraphBuilder.cover() {
    composable(route = Route) {
        CoverScreen()
    }
}

@Composable
fun CoverScreen() {
    TitleTemplate(
        title = "Hello! Kotlin Multiplatform",
        name = "Akexorcist",
        position = "Android GDE",
    )
}

@Preview
@Composable
fun CoverScreenPreview() {
    MaterialTheme {
        CoverScreen()
    }
}
