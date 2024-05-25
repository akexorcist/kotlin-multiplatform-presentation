package ui.navigation

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.theme.BackgroundColor

@Composable
fun rememberNavigationBarControllerState() = remember { NavigationBarControllerState() }

class NavigationBarControllerState {
    var action by mutableStateOf<Action?>(null)
        private set

    fun next() {
        action = Action.Next
    }

    fun back() {
        action = Action.Back
    }

    fun clear() {
        action = null
    }

    enum class Action {
        Next,
        Back,
    }
}


@Composable
fun NavigationBar(
    modifier: Modifier = Modifier,
    currentScreen: Screen,
    onPreviousClicked: () -> Unit,
    onNextClicked: () -> Unit,
    onGoToFirstClicked: () -> Unit,
    onGoToLastClicked: () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    var isDisplayed by remember { mutableStateOf(false) }

    AutoHidingLaunchedEffect(isHovered) {
        isDisplayed = isHovered
    }

    val animatedNavigationBarAlpha by animateFloatAsState(
        targetValue = if (isDisplayed) 1f else 0f,
        animationSpec = tween(
            durationMillis = 300,
            easing = LinearEasing,
        )
    )

    Row(
        modifier = modifier
            .hoverable(interactionSource)
            .alpha(animatedNavigationBarAlpha)
            .background(
                color = BackgroundColor.Bar.color,
                shape = RoundedCornerShape(100),
            )
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = onGoToFirstClicked) {
            Text(text = "<<")
        }
        Spacer(Modifier.width(2.dp))
        IconButton(onClick = onPreviousClicked) {
            Text(text = "<")
        }
        Spacer(Modifier.width(4.dp))
        Text(
            modifier = Modifier.width(100.dp),
            text = currentScreen.name.addSpaceForCamelCase(),
        )
        Spacer(Modifier.width(4.dp))
        IconButton(onClick = onNextClicked) {
            Text(text = ">")
        }
        Spacer(Modifier.width(2.dp))
        IconButton(onClick = onGoToLastClicked) {
            Text(text = ">>")
        }
    }
}

private fun String.addSpaceForCamelCase(): String {
    val regex = Regex("([a-z])([A-Z])")
    return regex.replace(this) { matchResult ->
        matchResult.groupValues[1] + " " + matchResult.groupValues[2]
    }
}

@Composable
private fun AutoHidingLaunchedEffect(
    isHovered: Boolean,
    onChanged: (Boolean) -> Unit
) {
    LaunchedEffect(isHovered) {
        if (isHovered) {
            onChanged(false)
        } else {
            delay(1000L)
            onChanged(true)
        }
    }
}

@Preview
@Composable
fun NavigationBarPreview() {
    MaterialTheme {
        NavigationBar(
            currentScreen = Screen.Introduction,
            onPreviousClicked = {},
            onNextClicked = {},
            onGoToFirstClicked = {},
            onGoToLastClicked = {},
        )
    }
}