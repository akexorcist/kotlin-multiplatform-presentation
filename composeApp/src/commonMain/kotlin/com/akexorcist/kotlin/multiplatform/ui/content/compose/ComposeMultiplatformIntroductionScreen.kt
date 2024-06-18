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

private val Route = Screen.ComposeMultiplatformIntroduction.name

fun NavController.navigateToComposeMultiplatformIntroduction() {
    navigate(Route)
}

fun NavGraphBuilder.composeMultiplatformIntroduction() {
    composable(route = Route) {
        ComposeMultiplatformIntroductionScreen()
    }
}

@Composable
fun ComposeMultiplatformIntroductionScreen() {
    DefaultTemplate(
        title = "Compose Multiplatform",
        content = "https://www.jetbrains.com/lp/compose-multiplatform/",
        tag = ComposeTag,
    )
}

@Preview
@Composable
fun ComposeMultiplatformIntroductionScreenPreview() {
    MaterialTheme {
        ComposeMultiplatformIntroductionScreen()
    }
}
