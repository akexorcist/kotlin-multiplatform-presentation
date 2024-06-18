package com.akexorcist.kotlin.multiplatform.ui.content.compose

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.ComposeTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen

private val Route = Screen.ComposeMultiplatformRender.name

fun NavController.navigateToComposeMultiplatformRender() {
    navigate(Route)
}

fun NavGraphBuilder.composeMultiplatformRender() {
    composable(route = Route) {
        ComposeMultiplatformRenderScreen()
    }
}

@Composable
fun ComposeMultiplatformRenderScreen() {
    DefaultTemplate(
        title = "Compose Multiplatform Render",
        content = "",
        tag = ComposeTag,
    )
}

@Preview
@Composable
fun ComposeMultiplatformRenderScreenPreview() {
    MaterialTheme {
        ComposeMultiplatformRenderScreen()
    }
}
