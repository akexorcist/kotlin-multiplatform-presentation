package com.akexorcist.kotlin.multiplatform.ui.content.library

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.LibraryTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen

private val Route = Screen.ThirdPartyAllPlatformLibrary.name

fun NavController.navigateToThirdPartyAllPlatformLibrary() {
    navigate(Route)
}

fun NavGraphBuilder.thirdPartyAllPlatformLibrary() {
    composable(route = Route) {
        ThirdPartyAllPlatformLibraryScreen()
    }
}

@Composable
fun ThirdPartyAllPlatformLibraryScreen() {
    DefaultCustomContentTemplate(
        title = "All Platforms",
        tag = LibraryTag,
    ) {
        Column {
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                LibraryContent(
                    modifier = Modifier.weight(1f),
                    type = "Dependency Injection",
                    name = "Koin, Kodein",
                )
                LibraryContent(
                    modifier = Modifier.weight(1f),
                    type = "Database",
                    name = "SQLDelight, Room, Realm",
                )
                LibraryContent(
                    modifier = Modifier.weight(1f),
                    type = "Key-value Storage",
                    name = "Multiplatform Settings, Datastore",
                )
            }
            Spacer(modifier = Modifier.height(48.dp))
            Row {
                LibraryContent(
                    modifier = Modifier.weight(1f),
                    type = "HTTP Client",
                    name = "Ktor",
                )
                LibraryContent(
                    modifier = Modifier.weight(1f),
                    type = "GraphQL Client",
                    name = "Apollo GraphQL",
                )
                LibraryContent(
                    modifier = Modifier.weight(1f),
                    type = "WebSocket",
                    name = "Krossbow",
                )
            }
            Spacer(modifier = Modifier.height(48.dp))
            Row {
                LibraryContent(
                    modifier = Modifier.weight(1f),
                    type = "Image Loader",
                    name = "Coil, Kamel",
                )
                LibraryContent(
                    modifier = Modifier.weight(1f),
                    type = "Location Access",
                    name = "Compass",
                )
                LibraryContent(
                    modifier = Modifier.weight(1f),
                    type = "File I/O",
                    name = "KStore, Okio",
                )
            }
        }
    }
}

@Preview
@Composable
fun ThirdPartyAllPlatformLibraryScreenPreview() {
    MaterialTheme {
        ThirdPartyAllPlatformLibraryScreen()
    }
}
