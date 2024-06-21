package com.akexorcist.kotlin.multiplatform.ui.content.strategy

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.RightCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.StrategyTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.scaledDp
import kotlinmultiplatform.composeapp.generated.resources.*
import kotlinmultiplatform.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

private val Route = Screen.SharePartialCode.name

fun NavController.navigateToSharePartialCode() {
    navigate(Route)
}

fun NavGraphBuilder.sharePartialCode() {
    composable(route = Route) {
        SharePartialCodeScreen()
    }
}

@Composable
fun SharePartialCodeScreen() {
    RightCustomContentTemplate(
        title = "Share a piece of logic",
        description = "Improve your app’s stability by sharing an isolated and critical part of the app. Reuse the Kotlin code you already have to keep the applications in sync.",
        tag = StrategyTag,
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(x = (-72).scaledDp()),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(Res.drawable.image_strategy_partial_logic_example),
                contentDescription = "Share piece of logic example",
            )
        }
    }
}

@Preview
@Composable
fun SharePartialCodeScreenPreview() {
    MaterialTheme {
        SharePartialCodeScreen()
    }
}
