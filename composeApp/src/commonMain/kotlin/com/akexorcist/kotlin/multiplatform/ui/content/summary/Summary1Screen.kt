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

private val Route = Screen.Summary1.name

fun NavController.navigateToSummary1() {
    navigate(Route)
}

fun NavGraphBuilder.summary1() {
    composable(route = Route) {
        Summary1Screen()
    }
}

@Composable
fun Summary1Screen() {
    DefaultTemplate(
        title = "Summary 1",
        content = "",
        tag = SummaryTag,
    )
}

@Preview
@Composable
fun Summary1ScreenPreview() {
    MaterialTheme {
        Summary1Screen()
    }
}
