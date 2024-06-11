package com.akexorcist.kotlin.multiplatform.ui.content.introduction

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.DoubleFrame
import com.akexorcist.kotlin.multiplatform.ui.component.DoubleFrameSize
import com.akexorcist.kotlin.multiplatform.ui.component.template.FullCustomTemplate
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen

private val Route = Screen.Introduction.name

fun NavController.navigateToIntroduction() {
    navigate(Route)
}

fun NavGraphBuilder.introduction() {
    composable(route = Route) {
        IntroductionScreen()
    }
}

@Composable
fun IntroductionScreen() {
    FullCustomTemplate {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Full Custom",
        )
    }
}

@Preview
@Composable
fun IntroductionScreenPreview() {
    MaterialTheme {
        IntroductionScreen()
    }
}
