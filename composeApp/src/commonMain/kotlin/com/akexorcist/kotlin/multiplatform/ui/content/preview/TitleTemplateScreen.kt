package com.akexorcist.kotlin.multiplatform.ui.content.preview

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.TitleTemplate
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.GradientColor

private val Route = Screen.ThankYouTemplate.name

fun NavController.navigateToTitleTemplate() {
    navigate(Route)
}

fun NavGraphBuilder.titleTemplate() {
    composable(route = Route) {
        TitleTemplateScreen()
    }
}

@Composable
fun TitleTemplateScreen() {
    TitleTemplate(
        title = "Here is a short title for a talk.",
        name = "Somkiat Khitwongwattana",
        position = "Android GDE",
        profileUrl = "https://akexorcist.dev/content/images/size/w2000/2020/06/about_me_header.jpg",
        frameColor = GradientColor.YellowGreen,
    )
}