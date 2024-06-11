package com.akexorcist.kotlin.multiplatform.ui.content.preview

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.HighlightStatisticTemplate
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen

private val Route = Screen.HighlightStatisticTemplate.name

fun NavController.navigateToHighlightStatisticTemplate() {
    navigate(Route)
}

fun NavGraphBuilder.highlightStatisticTemplate() {
    composable(route = Route) {
        HighlightStatisticTemplateScreen()
    }
}

@Composable
fun HighlightStatisticTemplateScreen() {
    HighlightStatisticTemplate(
        highlight = "90%",
        description = "Happy with Kotlin",
    )
}