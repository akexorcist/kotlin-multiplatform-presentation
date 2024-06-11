package com.akexorcist.kotlin.multiplatform.ui.content.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.CodeCustomContent
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.BackgroundColor

private val Route = Screen.CodeCustomContentTemplate.name

fun NavController.navigateToCodeCustomContent() {
    navigate(Route)
}

fun NavGraphBuilder.codeCustomContentTemplate() {
    composable(route = Route) {
        CodeCustomContentTemplateScreen()
    }
}

@Composable
fun CodeCustomContentTemplateScreen() {
    CodeCustomContent(
        code = "<html></html>"
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor.GrayEvent.color),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = "Custom Content")
        }
    }
}
