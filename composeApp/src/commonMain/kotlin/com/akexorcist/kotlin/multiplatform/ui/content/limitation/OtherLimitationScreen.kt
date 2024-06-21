package com.akexorcist.kotlin.multiplatform.ui.content.limitation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.*
import com.akexorcist.kotlin.multiplatform.ui.component.template.FullCustomTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.LimitationTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.BackgroundColor
import com.akexorcist.kotlin.multiplatform.ui.theme.scaled
import com.akexorcist.kotlin.multiplatform.ui.theme.scaledDp

private val Route = Screen.OtherLimitation.name

fun NavController.navigateToOtherLimitation() {
    navigate(Route)
}

fun NavGraphBuilder.otherLimitation() {
    composable(route = Route) {
        OtherLimitationScreen()
    }
}

@Composable
fun OtherLimitationScreen() {
    FullCustomTemplate {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor.GrayEvent.color)
                .padding(
                    vertical = VerticalScreenPadding.scaled(),
                    horizontal = HorizontalScreenPadding.scaled(),
                ),
        ) {
            Tag(data = LimitationTag)
            Spacer(modifier = Modifier.height(48.scaledDp()))
            listOf(
                "• Code Debugging on Xcode",
                "• Data passing between Kotlin and non JVM-based platform",
                "• Lack of some platform-specific API on non JVM-based platform",
                "• No Swift API accessible from Kotlin/Native, Objective-C API only",
                "• Kotlin/JS targets ES5, not ES6",
                "• Kotlin/Wasm not work with WebKit",
            ).forEach { content ->
                ContentText(text = content)
                Spacer(modifier = Modifier.height(16.scaledDp()))
            }
        }
    }
}

@Preview
@Composable
fun OtherLimitationScreenPreview() {
    MaterialTheme {
        OtherLimitationScreen()
    }
}
