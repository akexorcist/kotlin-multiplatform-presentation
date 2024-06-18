package com.akexorcist.kotlin.multiplatform.ui.content.summary

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.SummaryTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen

private val Route = Screen.LearningResource.name

fun NavController.navigateToLearningResource() {
    navigate(Route)
}

fun NavGraphBuilder.learningResource() {
    composable(route = Route) {
        LearningResourceScreen()
    }
}

@Composable
fun LearningResourceScreen() {
    DefaultTemplate(
        title = "Learning Resource",
        content = "",
        tag = SummaryTag,
    )
}

@Preview
@Composable
fun LearningResourceScreenPreview() {
    MaterialTheme {
        LearningResourceScreen()
    }
}
