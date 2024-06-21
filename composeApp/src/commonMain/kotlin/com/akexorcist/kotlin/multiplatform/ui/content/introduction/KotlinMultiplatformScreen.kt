package com.akexorcist.kotlin.multiplatform.ui.content.introduction

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.RightCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.IntroductionTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.scaledDp
import kotlinmultiplatform.composeapp.generated.resources.*
import kotlinmultiplatform.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

private val Route = Screen.KotlinMultiplatform.name

fun NavController.navigateToKotlinMultiplatform() {
    navigate(Route)
}

fun NavGraphBuilder.kotlinMultiplatform() {
    composable(route = Route) {
        KotlinMultiplatformScreen()
    }
}

@Composable
fun KotlinMultiplatformScreen() {
    RightCustomContentTemplate(
        title = "Kotlin Multiplatform",
        description = "Reuse Kotlin code across Android, iOS, web, desktop, and server-side while keeping native code if needed.",
        tag = IntroductionTag,
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(x = (-64).scaledDp()),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = Modifier.weight(0.5f))
            Image(
                modifier = Modifier.weight(4f),
                painter = painterResource(Res.drawable.ic_kotlin_multiplatform),
                contentDescription = "Kotlin Multiplatform",
                contentScale = ContentScale.FillWidth,
            )
            Spacer(modifier = Modifier.weight(1.5f))
        }
    }
}

@Preview
@Composable
fun KotlinMultiplatformScreenPreview() {
    MaterialTheme {
        KotlinMultiplatformScreen()
    }
}
