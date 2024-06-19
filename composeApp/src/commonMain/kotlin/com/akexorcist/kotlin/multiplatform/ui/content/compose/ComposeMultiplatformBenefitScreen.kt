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

private val Route = Screen.ComposeMultiplatformBenefit.name

fun NavController.navigateToComposeMultiplatformBenefit() {
    navigate(Route)
}

fun NavGraphBuilder.composeMultiplatformBenefit() {
    composable(route = Route) {
        ComposeMultiplatformBenefitScreen()
    }
}

@Composable
fun ComposeMultiplatformBenefitScreen() {
    DefaultTemplate(
        title = "Why Compose Multiplatform?",
        content = """
            
            • Accelerated UI development
            
            • Android UI skills for other platforms
            
            • An excellent ecosystem
            
            • Easy integration with every platform
            
            • Component-level reuse
        """.trimIndent(),
        tag = ComposeTag,
    )
}

@Preview
@Composable
fun ComposeMultiplatformBenefitScreenPreview() {
    MaterialTheme {
        ComposeMultiplatformBenefitScreen()
    }
}