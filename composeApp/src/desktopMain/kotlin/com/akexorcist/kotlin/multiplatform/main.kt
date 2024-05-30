package com.akexorcist.kotlin.multiplatform

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.input.key.*
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import com.akexorcist.kotlin.multiplatform.ui.content.App
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultTemplate
import com.akexorcist.kotlin.multiplatform.ui.navigation.navigationKeyEvent
import com.akexorcist.kotlin.multiplatform.ui.navigation.rememberScreenNavigationState

fun main() = application {
    val screenNavigationState = rememberScreenNavigationState()
    Window(
        onCloseRequest = ::exitApplication,
        title = "Kotlin Multiplatform",
        state = WindowState(
            size = DpSize(1280.dp, 720.dp),
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
        App(
            screenNavigationState = screenNavigationState
        )
    }
}


@Preview
@Composable
fun AppPreview() {
    MaterialTheme {
        DefaultTemplate(
            title = "Title",
            content = "Content",
        )
    }
}