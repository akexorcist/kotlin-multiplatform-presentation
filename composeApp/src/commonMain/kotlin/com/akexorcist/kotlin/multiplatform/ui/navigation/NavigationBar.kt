package com.akexorcist.kotlin.multiplatform.ui.navigation

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinmultiplatform.composeapp.generated.resources.*
import kotlinmultiplatform.composeapp.generated.resources.Res
import kotlinmultiplatform.composeapp.generated.resources.navigation_ic_back
import kotlinmultiplatform.composeapp.generated.resources.navigation_ic_last
import kotlinmultiplatform.composeapp.generated.resources.navigation_ic_next
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.theme.BackgroundColor

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
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(100),
            )
            .background(
                color = BackgroundColor.Bar.color,
                shape = RoundedCornerShape(100),
            )
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            modifier = Modifier.size(48.dp),
            onClick = onGoToFirstClicked,
        ) {
            Icon(
                imageVector = vectorResource(Res.drawable.navigation_ic_first),
                contentDescription = "First screen",
            )
        }
        Spacer(Modifier.width(2.dp))
        IconButton(
            modifier = Modifier.size(48.dp),
            onClick = onPreviousClicked,
        ) {
            Icon(
                imageVector = vectorResource(Res.drawable.navigation_ic_back),
                contentDescription = "Back screen",
            )
        }
        Spacer(Modifier.width(4.dp))
        Text(
            modifier = Modifier.width(200.dp),
            text = currentScreen.name.addSpaceForCamelCase(),
            fontSize = 14.sp,
            lineHeight = 16.sp,
            textAlign = TextAlign.Center,
        )
        Spacer(Modifier.width(4.dp))
        IconButton(
            modifier = Modifier.size(48.dp),
            onClick = onNextClicked,
        ) {
            Icon(
                imageVector = vectorResource(Res.drawable.navigation_ic_next),
                contentDescription = "Next screen",
            )
        }
        Spacer(Modifier.width(2.dp))
        IconButton(
            modifier = Modifier.size(48.dp),
            onClick = onGoToLastClicked,
        ) {
            Icon(
                imageVector = vectorResource(Res.drawable.navigation_ic_last),
                contentDescription = "Last screen",
            )
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