package com.akexorcist.kotlin.multiplatform.ui.content.compose

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.ContentText
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.ComposeTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen

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
        Spacer(modifier = Modifier.height(16.dp))
        ContentText(text = "• Platform UI Interoperability")
        Spacer(modifier = Modifier.height(16.dp))
        ContentText(text = "• UI Rendering Performance")
        Spacer(modifier = Modifier.height(16.dp))
        ContentText(text = "• UI Inspection Tools")
        Spacer(modifier = Modifier.height(16.dp))
        ContentText(text = "• WebAssembly requires for Web")
    }
}

@Preview
@Composable
fun ComposeMultiplatformLimitationScreenPreview() {
    MaterialTheme {
        ComposeMultiplatformLimitationScreen()
    }
}
