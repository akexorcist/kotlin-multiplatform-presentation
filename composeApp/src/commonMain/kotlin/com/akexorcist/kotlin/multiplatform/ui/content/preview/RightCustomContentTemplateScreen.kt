package com.akexorcist.kotlin.multiplatform.ui.content.preview

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.TagData
import com.akexorcist.kotlin.multiplatform.ui.component.template.RightCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.GradientColor

private val Route = Screen.RightCustomContentTemplate.name

fun NavController.navigateToRightCustomContentTemplate() {
    navigate(Route)
}

fun NavGraphBuilder.rightCustomContentTemplate() {
    composable(route = Route) {
        RightCustomContentTemplateScreen()
    }
}

@Composable
fun RightCustomContentTemplateScreen() {
    RightCustomContentTemplate(
        title = "Headline goes here",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. \n" +
                "\n" +
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident.",
        tag = TagData(
            text = "Section 1",
            background = GradientColor.YellowGreen,
        ),
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Lorem ipsum",
        )
    }
}
