package com.akexorcist.kotlin.multiplatform.ui.content.introduction

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.ContentText
import com.akexorcist.kotlin.multiplatform.ui.component.template.FullCustomTemplate
import com.akexorcist.kotlin.multiplatform.ui.component.template.RightCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.IntroductionTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.BackgroundColor
import kotlinmultiplatform.composeapp.generated.resources.*
import kotlinmultiplatform.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

private val Route = Screen.KotlinMultiplatformLogo.name

fun NavController.navigateToKotlinMultiplatformLogo() {
    navigate(Route)
}

fun NavGraphBuilder.kotlinMultiplatformLogo() {
    composable(route = Route) {
        KotlinMultiplatformLogoScreen()
    }
}

@Composable
fun KotlinMultiplatformLogoScreen() {
    FullCustomTemplate {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor.GrayEvent.color)
                .align(Alignment.Center),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Image(
                    modifier = Modifier.fillMaxHeight(0.5f),
                    painter = painterResource(Res.drawable.ic_kotlin_multiplatform_old),
                    contentDescription = "Olg logo",
                )
                Spacer(modifier = Modifier.height(32.dp))
                ContentText(text = "Before")
            }
            Spacer(modifier = Modifier.weight(1f))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Image(
                    modifier = Modifier.fillMaxHeight(0.5f),
                    painter = painterResource(Res.drawable.ic_kotlin_multiplatform),
                    contentDescription = "Olg logo",
                )
                Spacer(modifier = Modifier.height(32.dp))
                ContentText(text = "Now")
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Preview
@Composable
fun KotlinMultiplatformLogoScreenPreview() {
    MaterialTheme {
        KotlinMultiplatformLogoScreen()
    }
}
