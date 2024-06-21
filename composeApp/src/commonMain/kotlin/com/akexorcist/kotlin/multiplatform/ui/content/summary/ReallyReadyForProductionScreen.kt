package com.akexorcist.kotlin.multiplatform.ui.content.summary

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultTemplate
import com.akexorcist.kotlin.multiplatform.ui.component.template.SectionTitleTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.AdoptionTag
import com.akexorcist.kotlin.multiplatform.ui.content.SummaryTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen

private val Route = Screen.ReallyReadyForProduction.name

fun NavController.navigateToReallyReadyForProduction() {
    navigate(Route)
}

fun NavGraphBuilder.reallyReadyForProduction() {
    composable(route = Route) {
        ReallyReadyForProductionScreen()
    }
}

@Composable
fun ReallyReadyForProductionScreen() {
    SectionTitleTemplate(
        title = """
            Really Ready for Production?
            
            🤔🤔🤔
        """.trimIndent(),
        description = "",
        tag = SummaryTag,
    )
}

@Preview
@Composable
fun ReallyReadyForProductionScreenPreview() {
    MaterialTheme {
        ReallyReadyForProductionScreen()
    }
}
