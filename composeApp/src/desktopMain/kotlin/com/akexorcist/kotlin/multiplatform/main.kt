package com.akexorcist.kotlin.multiplatform

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import com.akexorcist.kotlin.multiplatform.ui.component.TagData
import com.akexorcist.kotlin.multiplatform.ui.content.App
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultTemplate
import com.akexorcist.kotlin.multiplatform.ui.component.WebViewProvider
import com.akexorcist.kotlin.multiplatform.ui.navigation.navigationKeyEvent
import com.akexorcist.kotlin.multiplatform.ui.navigation.rememberScreenNavigationState
import com.akexorcist.kotlin.multiplatform.ui.theme.GradientColor
import io.kamel.core.config.KamelConfig
import io.kamel.core.config.takeFrom
import io.kamel.image.config.Default
import io.kamel.image.config.LocalKamelConfig
import io.kamel.image.config.resourcesFetcher

fun main() = application {
    val screenNavigationState = rememberScreenNavigationState()
    Window(
        onCloseRequest = ::exitApplication,
        title = "Kotlin Multiplatform",
        state = WindowState(
            size = DpSize(1280.dp, 720.dp),
            placement = WindowPlacement.Maximized,
        ),
        onKeyEvent = { event ->
            navigationKeyEvent(
                event = event,
                onSpace = { screenNavigationState.next() },
                onMetaRight = { screenNavigationState.last() },
                onRight = { screenNavigationState.next() },
                onMetaLeft = { screenNavigationState.first() },
                onLeft = { screenNavigationState.back() },
            )
        }
    ) {
        CompositionLocalProvider(
            value = LocalKamelConfig provides KamelConfig {
                takeFrom(KamelConfig.Default)
                resourcesFetcher()
            }
        ) {
            WebViewProvider {
                App(
                    screenNavigationState = screenNavigationState
                )
            }
        }
    }
}


@Preview
@Composable
fun AppPreview() {
    MaterialTheme {
        DefaultTemplate(
            title = "Title",
            content = "Content",
            tag = TagData("About Kotlin", GradientColor.BlueRed),
        )
    }
}