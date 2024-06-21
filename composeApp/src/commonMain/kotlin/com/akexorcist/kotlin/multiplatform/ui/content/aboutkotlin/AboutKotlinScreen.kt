package com.akexorcist.kotlin.multiplatform.ui.content.aboutkotlin

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.TagData
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultTemplate
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.GradientColor

private val Route = Screen.AboutKotlin.name

fun NavController.navigateToAboutKotlin() {
    navigate(Route)
}

fun NavGraphBuilder.aboutKotlin() {
    composable(route = Route) {
        AboutKotlinScreen()
    }
}

@Composable
fun AboutKotlinScreen() {
    DefaultTemplate(
        title = "About Kotlin",
        content = "Content about Kotlin",
        tag = TagData("About Kotlin", GradientColor.BlueRed),
    )
}

@Preview
@Composable
fun AboutKotlinScreenPreview() {
    MaterialTheme {
        AboutKotlinScreen()
    }
}
