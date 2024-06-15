package com.akexorcist.kotlin.multiplatform.ui.content.introduction

import androidx.compose.foundation.Image
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
import com.akexorcist.kotlin.multiplatform.ui.component.template.RightCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.IntroductionTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import kotlinmultiplatform.composeapp.generated.resources.*
import kotlinmultiplatform.composeapp.generated.resources.Res
import kotlinmultiplatform.composeapp.generated.resources.ic_android
import kotlinmultiplatform.composeapp.generated.resources.ic_kotlin
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.vectorResource

private val Route = Screen.KotlinAndAndroid.name

fun NavController.navigateToKotlinAndAndroid() {
    navigate(Route)
}

fun NavGraphBuilder.kotlinAndAndroid() {
    composable(route = Route) {
        KotlinAndAndroidScreen()
    }
}

@Composable
fun KotlinAndAndroidScreen() {
    RightCustomContentTemplate(
        title = "Android’s commitment to Kotlin",
        description = "At Google I/O 2019, Google announced that Android development will be increasingly Kotlin-first.\n\nWhen building new Android development tools and content, such as Jetpack libraries, samples, documentation, and training content, they will design them with Kotlin users in mind.",
        tag = IntroductionTag,
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(x = (-128).dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = Modifier
                    .height(96.dp)
                    .fillMaxWidth(),
                painter = painterResource(Res.drawable.ic_android),
                contentDescription = "Android",
                contentScale = ContentScale.Fit,
            )
            Spacer(modifier = Modifier.height(32.dp))
            Image(
                modifier = Modifier.size(48.dp),
                imageVector = vectorResource(Res.drawable.ic_favourite),
                contentDescription = "Love",
                contentScale = ContentScale.Fit,
            )
            Spacer(modifier = Modifier.height(32.dp))
            Image(
                modifier = Modifier
                    .height(64.dp)
                    .fillMaxWidth(),
                painter = painterResource(Res.drawable.ic_kotlin),
                contentDescription = "Kotlin",
                contentScale = ContentScale.Fit,
            )
        }
    }
}

@Preview
@Composable
fun KotlinAndAndroidScreenPreview() {
    MaterialTheme {
        KotlinAndAndroidScreen()
    }
}
