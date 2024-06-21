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

private val Route = Screen.IntroKotlin.name

fun NavController.navigateToIntroKotlin() {
    navigate(Route)
}

fun NavGraphBuilder.introKotlin() {
    composable(route = Route) {
        IntroKotlinScreen()
    }
}

@Composable
fun IntroKotlinScreen() {
    RightCustomContentTemplate(
        title = "Kotlin",
        description = """
            A programming language that makes coding concise, cross-platform, and fun.
            
            • Expressive and concise
            • Safer code
            • Interoperable
            • Structured Concurrency
        """.trimIndent(),
        tag = IntroductionTag,
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(x = (-128).scaledDp()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth(),
                painter = painterResource(Res.drawable.ic_kotlin_kodee),
                contentDescription = "Kotlin",
                contentScale = ContentScale.Fit,
            )
        }
    }
}

@Preview
@Composable
fun IntroKotlinScreenPreview() {
    MaterialTheme {
        IntroKotlinScreen()
    }
}
