package com.akexorcist.kotlin.multiplatform.ui.content.summary

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.CustomContentItem
import com.akexorcist.kotlin.multiplatform.ui.component.template.MultipleCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.SummaryTag
import com.akexorcist.kotlin.multiplatform.ui.extension.gradientTint
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.GradientColor
import com.akexorcist.kotlin.multiplatform.ui.theme.scaledDp
import kotlinmultiplatform.composeapp.generated.resources.*
import kotlinmultiplatform.composeapp.generated.resources.Res
import kotlinmultiplatform.composeapp.generated.resources.ic_factor_platform
import kotlinmultiplatform.composeapp.generated.resources.ic_factor_team
import org.jetbrains.compose.resources.painterResource

private val Route = Screen.DecisionMakingFactor.name

fun NavController.navigateToDecisionMakingFactor() {
    navigate(Route)
}

fun NavGraphBuilder.decisionMakingFactor() {
    composable(route = Route) {
        DecisionMakingFactorScreen()
    }
}

@Composable
fun DecisionMakingFactorScreen() {
    MultipleCustomContentTemplate(
        contents = listOf(
            CustomContentItem(
                title = "",
                description = "",
                content = {},
                weight = 0.25f,
            ),
            CustomContentItem(
                title = "Team Knowledge",
                description = "What knowledge does your team already have?",
                content = {
                    Image(
                        modifier = Modifier
                            .size(120.scaledDp())
                            .gradientTint(GradientColor.BlueRed)
                            .offset(x = 2.scaledDp()),
                        painter = painterResource(Res.drawable.ic_factor_team),
                        contentDescription = "Share a piece of logic",
                    )
                },
            ),
            CustomContentItem(
                title = "Platform",
                description = "Mobile? Desktop? Web?",
                content = {
                    Image(
                        modifier = Modifier
                            .size(120.scaledDp())
                            .gradientTint(GradientColor.BlueRed)
                            .offset(x = (-7).scaledDp()),
                        painter = painterResource(Res.drawable.ic_factor_platform),
                        contentDescription = "Share a piece of logic",
                    )
                },
            ),
            CustomContentItem(
                title = "App Functionality",
                description = "How complex of your app functionality will be?",
                content = {
                    Image(
                        modifier = Modifier
                            .size(120.scaledDp())
                            .gradientTint(GradientColor.BlueRed)
                            .offset(x = (-12).scaledDp()),
                        painter = painterResource(Res.drawable.ic_factor_functionality),
                        contentDescription = "App Functionality",
                    )
                },
            ),
            CustomContentItem(
                title = "Usage",
                description = "How much of it will be used? Some, part, or all?",
                content = {
                    Image(
                        modifier = Modifier
                            .size(120.scaledDp())
                            .gradientTint(GradientColor.BlueRed)
                            .offset(x = (-14).scaledDp()),
                        painter = painterResource(Res.drawable.ic_factor_usage),
                        contentDescription = "Usage",
                    )
                },
            ),
            CustomContentItem(
                title = "",
                description = "",
                content = {},
                weight = 0.25f,
            ),
        ),
        tag = SummaryTag,
    )
}

@Preview
@Composable
fun DecisionMakingFactorScreenPreview() {
    MaterialTheme {
        DecisionMakingFactorScreen()
    }
}
