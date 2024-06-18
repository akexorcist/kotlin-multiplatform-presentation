package com.akexorcist.kotlin.multiplatform.ui.content.summary

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.component.template.FullCustomTemplate
import com.akexorcist.kotlin.multiplatform.ui.component.template.ThankYouTemplate
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.GradientColor

private val Route = Screen.ThankYou.name

fun NavController.navigateToThankYou() {
    navigate(Route)
}

fun NavGraphBuilder.thankYou() {
    composable(route = Route) {
        ThankYouScreen()
    }
}

@Composable
fun ThankYouScreen() {
    ThankYouTemplate(
        title = "Thank You",
        name = "Somkiat Khitwongwattana",
        position = "Android GDE",
        profileUrl = "https://akexorcist.dev/content/images/size/w2000/2020/06/about_me_header.jpg",
        frameColor = GradientColor.YellowGreen,
    )
}

@Preview
@Composable
fun ThankYouScreenPreview() {
    MaterialTheme {
        ThankYouScreen()
    }
}
