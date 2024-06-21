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

private val Route = Screen.ShareLogicCode.name

fun NavController.navigateToShareLogicCode() {
    navigate(Route)
}

fun NavGraphBuilder.shareLogicCode() {
    composable(route = Route) {
        ShareLogicCodeScreen()
    }
}

@Composable
fun ShareLogicCodeScreen() {
    RightCustomContentTemplate(
        title = "Share logic and keep the UI native",
        description = "Implement data handling and business logic just once. Keep the UI native to meet the most stringent requirements.",
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
                painter = painterResource(Res.drawable.image_strategy_all_logic_example),
                contentDescription = "Share all logic example",
            )
        }
    }
}

@Preview
@Composable
fun ShareLogicCodeScreenPreview() {
    MaterialTheme {
        ShareLogicCodeScreen()
    }
}
