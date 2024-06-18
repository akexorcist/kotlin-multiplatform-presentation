package com.akexorcist.kotlin.multiplatform.ui.content.adoption

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.AdoptionTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen

private val Route = Screen.ThirdPartyLibrary.name

fun NavController.navigateToThirdPartyLibrary() {
    navigate(Route)
}

fun NavGraphBuilder.thirdPartyLibrary() {
    composable(route = Route) {
        ThirdPartyLibraryScreen()
    }
}

@Composable
fun ThirdPartyLibraryScreen() {
    DefaultTemplate(
        title = "Third Parry Library",
        content = "",
        tag = AdoptionTag,
    )
}

@Preview
@Composable
fun ThirdPartyLibraryScreenPreview() {
    MaterialTheme {
        ThirdPartyLibraryScreen()
    }
}
