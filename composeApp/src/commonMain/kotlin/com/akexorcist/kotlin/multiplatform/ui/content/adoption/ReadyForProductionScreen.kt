package com.akexorcist.kotlin.multiplatform.ui.content.adoption

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.SectionTitleTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.AdoptionTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen

private val Route = Screen.ReadyForProduction.name

fun NavController.navigateToReadyForProduction() {
    navigate(Route)
}

fun NavGraphBuilder.readyForProduction() {
    composable(route = Route) {
        ReadyForProductionScreen()
    }
}

@Composable
fun ReadyForProductionScreen() {
    SectionTitleTemplate(
        title = "Ready for Production?",
        description = "Or is it just a framework for hobby only?",
        tag = AdoptionTag,
    )
}

@Preview
@Composable
fun ReadyForProductionScreenPreview() {
    MaterialTheme {
        ReadyForProductionScreen()
    }
}
