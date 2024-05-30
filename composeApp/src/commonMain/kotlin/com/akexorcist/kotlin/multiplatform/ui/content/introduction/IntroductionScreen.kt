package com.akexorcist.kotlin.multiplatform.ui.content.introduction

import com.akexorcist.kotlin.multiplatform.ui.component.template.CoverTemplate
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen

private val Route = Screen.Introduction.name

fun NavController.navigateToIntroduction() {
    navigate(Route)
}

fun NavGraphBuilder.introduction() {
    composable(route = Route) {
        IntroductionScreen()
    }
}

@Composable
fun IntroductionScreen() {
    CoverTemplate(
        title = "Hello! Kotlin Multiplatform",
    )
}

@Preview
@Composable
fun IntroductionScreenPreview() {
    MaterialTheme {
        IntroductionScreen()
    }
}
