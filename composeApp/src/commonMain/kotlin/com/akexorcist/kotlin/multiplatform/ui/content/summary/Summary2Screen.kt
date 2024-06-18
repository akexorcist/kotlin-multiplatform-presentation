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

private val Route = Screen.Summary2.name

fun NavController.navigateToSummary2() {
    navigate(Route)
}

fun NavGraphBuilder.summary2() {
    composable(route = Route) {
        Summary2Screen()
    }
}

@Composable
fun Summary2Screen() {
    DefaultTemplate(
        title = "Summary 2",
        content = "",
        tag = SummaryTag,
    )
}

@Preview
@Composable
fun Summary2ScreenPreview() {
    MaterialTheme {
        Summary2Screen()
    }
}
