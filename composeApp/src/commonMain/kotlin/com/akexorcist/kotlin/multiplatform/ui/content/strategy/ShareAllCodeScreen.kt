package com.akexorcist.kotlin.multiplatform.ui.content.strategy

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.RightCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.StrategyTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import kotlinmultiplatform.composeapp.generated.resources.*
import kotlinmultiplatform.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

private val Route = Screen.ShareAllCode.name

fun NavController.navigateToShareAllCode() {
    navigate(Route)
}

fun NavGraphBuilder.shareAllCode() {
    composable(route = Route) {
        ShareAllCodeScreen()
    }
}

@Composable
fun ShareAllCodeScreen() {
    RightCustomContentTemplate(
        title = "Share up to 100% of the code",
        description = "Elevate development efficiency and share up to 100% of your code with Compose Multiplatform.",
        tag = StrategyTag,
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(x = (-72).dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(Res.drawable.image_strategy_all_example),
                contentDescription = "Share all code example",
            )
        }
    }
}

@Preview
@Composable
fun ShareAllCodeScreenPreview() {
    MaterialTheme {
        ShareAllCodeScreen()
    }
}
