package com.akexorcist.kotlin.multiplatform.ui.content.adoption

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.AdoptionTag
import com.akexorcist.kotlin.multiplatform.ui.content.ComposeTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen

private val Route = Screen.KotlinMultiplatformBenefit.name

fun NavController.navigateToKotlinMultiplatformBenefit() {
    navigate(Route)
}

fun NavGraphBuilder.kotlinMultiplatformBenefit() {
    composable(route = Route) {
        KotlinMultiplatformBenefitScreen()
    }
}

@Composable
fun KotlinMultiplatformBenefitScreen() {
    DefaultTemplate(
        title = "Kotlin Multiplatform Benefit",
        content = "",
        tag = AdoptionTag,
    )
}

@Preview
@Composable
fun KotlinMultiplatformBenefitScreenPreview() {
    MaterialTheme {
        KotlinMultiplatformBenefitScreen()
    }
}
