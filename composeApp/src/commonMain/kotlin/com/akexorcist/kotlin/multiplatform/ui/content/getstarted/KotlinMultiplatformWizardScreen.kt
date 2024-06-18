package com.akexorcist.kotlin.multiplatform.ui.content.getstarted

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.GetStartedTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen

private val Route = Screen.KotlinMultiplatformWizard.name

fun NavController.navigateToKotlinMultiplatformWizard() {
    navigate(Route)
}

fun NavGraphBuilder.kotlinMultiplatformWizard() {
    composable(route = Route) {
        KotlinMultiplatformWizardScreen()
    }
}

@Composable
fun KotlinMultiplatformWizardScreen() {
    DefaultTemplate(
        title = "Kotlin Multiplatform Wizard",
        content = "",
        tag = GetStartedTag,
    )
}

@Preview
@Composable
fun KotlinMultiplatformWizardScreenPreview() {
    MaterialTheme {
        KotlinMultiplatformWizardScreen()
    }
}
