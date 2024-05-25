package ui.introduction

import ui.component.template.CoverTemplate
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.navigation.Screen

fun NavController.navigateToIntroduction() {
    navigate(Screen.Introduction.name)
}

fun NavGraphBuilder.introduction() {
    composable(route = Screen.Introduction.name) {
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
