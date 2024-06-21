package com.akexorcist.kotlin.multiplatform.ui.content.library

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.LibraryTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.scaledDp

private val Route = Screen.ThirdPartyMobileLibrary.name

fun NavController.navigateToThirdPartyMobileLibrary() {
    navigate(Route)
}

fun NavGraphBuilder.thirdPartyMobileLibrary() {
    composable(route = Route) {
        ThirdPartyMobileLibraryScreen()
    }
}

@Composable
fun ThirdPartyMobileLibraryScreen() {
    DefaultCustomContentTemplate(
        title = "Mobile",
        tag = LibraryTag,
    ) {
        Column {
            Spacer(modifier = Modifier.height(16.scaledDp()))
            Row {
                LibraryContent(
                    modifier = Modifier.weight(1f),
                    type = "Architecture",
                    name = "Decompose, Moko MVVM",
                )
                LibraryContent(
                    modifier = Modifier.weight(1f),
                    type = "Permission",
                    name = "Moko Permission",
                )
                LibraryContent(
                    modifier = Modifier.weight(1f),
                    type = "Biometrics",
                    name = "Moko Biometric",
                )
            }
            Spacer(modifier = Modifier.height(32.scaledDp()))
            Row {
                LibraryContent(
                    modifier = Modifier.weight(1f),
                    type = "Image Picker",
                    name = "peekaboo",
                )
                LibraryContent(
                    modifier = Modifier.weight(1f),
                    type = "WebView",
                    name = "compose-webview-multiplatform",
                )
                Spacer(modifier = Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.height(32.scaledDp()))
            Row {
                LibraryContent(
                    modifier = Modifier.weight(1f),
                    type = "Swift-friendly",
                    name = "SKIE",
                )
                LibraryContent(
                    modifier = Modifier.weight(1f),
                    type = "Xcode Support",
                    name = "xcode-kotlin",
                )
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}

@Preview
@Composable
fun ThirdPartyMobileLibraryScreenPreview() {
    MaterialTheme {
        ThirdPartyMobileLibraryScreen()
    }
}
