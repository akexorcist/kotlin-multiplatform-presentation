package com.akexorcist.kotlin.multiplatform.ui.content.preview

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.ThankYouTemplate
import com.akexorcist.kotlin.multiplatform.ui.component.template.TitleTemplate
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.GradientColor

private val Route = Screen.TitleTemplate.name

fun NavController.navigateToThankYouTemplate() {
    navigate(Route)
}

fun NavGraphBuilder.thankYouTemplate() {
    composable(route = Route) {
        ThankYouTemplateScreen()
    }
}

@Composable
fun ThankYouTemplateScreen() {
    ThankYouTemplate(
        title = "Thank You",
        name = "Somkiat Khitwongwattana",
        position = "Android GDE",
        frameColor = GradientColor.YellowGreen,
    )
}
