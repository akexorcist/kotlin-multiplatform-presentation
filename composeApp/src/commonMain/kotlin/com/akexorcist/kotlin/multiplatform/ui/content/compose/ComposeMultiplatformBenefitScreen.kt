package com.akexorcist.kotlin.multiplatform.ui.content.compose

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.ContentText
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.ComposeTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.scaledDp

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
    DefaultCustomContentTemplate(
        title = "Why Compose Multiplatform?",
        tag = ComposeTag,
    ) {
        listOf(
            "• Accelerated UI development",
            "• Android UI skills for other platforms",
            "• An excellent ecosystem",
            "• Easy integration with every platform",
            "• Component-level reuse",
        ).forEach { content ->
            ContentText(text = content)
            Spacer(modifier = Modifier.height(16.scaledDp()))
        }
    }
}

@Preview
@Composable
fun ComposeMultiplatformBenefitScreenPreview() {
    MaterialTheme {
        ComposeMultiplatformBenefitScreen()
    }
}
