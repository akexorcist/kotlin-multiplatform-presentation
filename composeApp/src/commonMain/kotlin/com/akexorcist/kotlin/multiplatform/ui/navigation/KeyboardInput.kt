package com.akexorcist.kotlin.multiplatform.ui.navigation

import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.*

fun Modifier.onNavigationKeyEvent(
    onSpace: () -> Unit,
    onMetaRight: () -> Unit,
    onRight: () -> Unit,
    onMetaLeft: () -> Unit,
    onLeft: () -> Unit,
) = this.onKeyEvent { event ->
    navigationKeyEvent(
        event = event,
        onSpace = onSpace,
        onMetaRight = onMetaRight,
        onRight = onRight,
        onMetaLeft = onMetaLeft,
        onLeft = onLeft,
    )
}

fun navigationKeyEvent(
    event: KeyEvent,
    onSpace: () -> Unit,
    onMetaRight: () -> Unit,
    onRight: () -> Unit,
    onMetaLeft: () -> Unit,
    onLeft: () -> Unit,
): Boolean = when {
    event.key == Key.Spacebar && event.type == KeyEventType.KeyDown -> {
        onSpace()
        true
    }

    event.key == Key.DirectionRight && event.type == KeyEventType.KeyDown && event.isMetaPressed -> {
        onMetaRight()
        true
    }

    event.key == Key.DirectionRight && event.type == KeyEventType.KeyDown -> {
        onRight()
        true
    }

    event.key == Key.DirectionLeft && event.type == KeyEventType.KeyDown && event.isMetaPressed -> {
        onMetaLeft()
        true
    }

    event.key == Key.DirectionLeft && event.type == KeyEventType.KeyDown -> {
        onLeft()
        true
    }

    else -> false
}
