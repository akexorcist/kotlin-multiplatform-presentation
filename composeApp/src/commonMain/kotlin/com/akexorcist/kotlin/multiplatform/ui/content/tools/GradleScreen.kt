package com.akexorcist.kotlin.multiplatform.ui.content.tools

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.ToolsTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen

private val Route = Screen.Gradle.name

fun NavController.navigateToGradle() {
    navigate(Route)
}

fun NavGraphBuilder.gradle() {
    composable(route = Route) {
        GradleScreen()
    }
}

@Composable
fun GradleScreen() {
    DefaultTemplate(
        title = "Gradle",
        content = "",
        tag = ToolsTag,
    )
}

@Preview
@Composable
fun GradleScreenPreview() {
    MaterialTheme {
        GradleScreen()
    }
}
