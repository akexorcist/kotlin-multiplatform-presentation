package com.akexorcist.kotlin.multiplatform.ui.content.preview

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.TagData
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultTemplate
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.GradientColor

private val Route = Screen.DefaultTemplate.name

fun NavController.navigateToDefaultTemplate() {
    navigate(Route)
}

fun NavGraphBuilder.defaultTemplate() {
    composable(route = Route) {
        DefaultTemplateScreen()
    }
}

@Composable
fun DefaultTemplateScreen() {
    DefaultTemplate(
        title = "Headline goes here",
        content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. \n" +
                "\n" +
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident.",
        tag = TagData(
            text = "Section 1",
            background = GradientColor.YellowRed,
        )
    )
}
