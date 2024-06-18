package com.akexorcist.kotlin.multiplatform.ui.content.strategy

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.CustomContentItem
import com.akexorcist.kotlin.multiplatform.ui.component.template.MultipleCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.StrategyTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import kotlinmultiplatform.composeapp.generated.resources.*
import kotlinmultiplatform.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

private val Route = Screen.ShareCodeStrategy.name

fun NavController.navigateToShareCodeStrategy() {
    navigate(Route)
}

fun NavGraphBuilder.shareCodeStrategy() {
    composable(route = Route) {
        ShareCodeStrategyScreen()
    }
}

@Composable
fun ShareCodeStrategyScreen() {
    MultipleCustomContentTemplate(
        contents = listOf(
            CustomContentItem(
                title = "Share a piece of logic",
                description = "Sharing an isolated and critical part of the app.",
                content = {
                    Image(
                        modifier = Modifier
                            .width(300.dp)
                            .offset(x = (-20).dp),
                        painter = painterResource(Res.drawable.image_share_code_strategy_partial_logic),
                        contentDescription = "Share a piece of logic",
                    )
                },
            ),
            CustomContentItem(
                title = "Share logic and keep the UI native",
                description = "Implement data handling and business logic just once.",
                content = {
                    Image(
                        modifier = Modifier
                            .width(300.dp)
                            .offset(x = (-20).dp),
                        painter = painterResource(Res.drawable.image_share_code_strategy_all_logic),
                        contentDescription = "Share logic",
                    )
                },
            ),
            CustomContentItem(
                title = "Share up to 100% of the code",
                description = "Elevate development efficiency and share up to 100% of your code",
                content = {
                    Image(
                        modifier = Modifier
                            .width(300.dp)
                            .offset(x = (-20).dp),
                        painter = painterResource(Res.drawable.image_share_code_strategy_all),
                        contentDescription = "Share UI and logic",
                    )
                },
            ),
        ),
        tag = StrategyTag,
    )
}

@Preview
@Composable
fun ShareCodeStrategyScreenPreview() {
    MaterialTheme {
        ShareCodeStrategyScreen()
    }
}
