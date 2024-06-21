package com.akexorcist.kotlin.multiplatform.ui.content.compose

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.ContentText
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.ComposeTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.scaledDp

private val Route = Screen.ComposeMultiplatformLimitation.name

fun NavController.navigateToComposeMultiplatformLimitation() {
    navigate(Route)
}

fun NavGraphBuilder.composeMultiplatformLimitation() {
    composable(route = Route) {
        ComposeMultiplatformLimitationScreen()
    }
}

@Composable
fun ComposeMultiplatformLimitationScreen() {
    DefaultCustomContentTemplate(
        title = "Limitation",
        tag = ComposeTag,
    ) {
        Spacer(modifier = Modifier.height(16.scaledDp()))
        ContentText(text = "• Platform UI Interoperability")
        Spacer(modifier = Modifier.height(16.scaledDp()))
        ContentText(text = "• UI Rendering Performance")
        Spacer(modifier = Modifier.height(16.scaledDp()))
        ContentText(text = "• UI Inspection Tools")
        Spacer(modifier = Modifier.height(16.scaledDp()))
        ContentText(text = "• WebAssembly requires for Web")
        Spacer(modifier = Modifier.height(16.scaledDp()))
        ContentText(text = "• WebView on Web")
    }
}

@Preview
@Composable
fun ComposeMultiplatformLimitationScreenPreview() {
    MaterialTheme {
        ComposeMultiplatformLimitationScreen()
    }
}
