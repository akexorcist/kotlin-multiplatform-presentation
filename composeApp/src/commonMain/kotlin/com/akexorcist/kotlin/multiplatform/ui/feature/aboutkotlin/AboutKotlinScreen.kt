package com.akexorcist.kotlin.multiplatform.ui.feature.aboutkotlin

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultTemplate
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen

fun NavController.navigateToAboutKotlin() {
    navigate(Screen.AboutKotlin.name)
}

fun NavGraphBuilder.aboutKotlin() {
    composable(route = Screen.AboutKotlin.name) {
        AboutKotlinScreen()
    }
}

@Composable
fun AboutKotlinScreen() {
    DefaultTemplate(
        title = "About Kotlin",
        content = "Content about Kotlin"
    )
}

@Preview
@Composable
fun AboutKotlinScreenPreview() {
    MaterialTheme {
        AboutKotlinScreen()
    }
}
