package com.akexorcist.kotlin.multiplatform.ui.content.tools

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.LargeContentText
import com.akexorcist.kotlin.multiplatform.ui.component.SmallContentText
import com.akexorcist.kotlin.multiplatform.ui.component.Tag
import com.akexorcist.kotlin.multiplatform.ui.component.template.FullCustomTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.ToolsTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.BackgroundColor
import com.multiplatform.webview.web.WebView
import com.multiplatform.webview.web.rememberWebViewState

private val Route = Screen.KDoctor.name
private const val KDoctorWebUrl = "https://github.com/Kotlin/kdoctor"

fun NavController.navigateToKDoctor() {
    navigate(Route)
}

fun NavGraphBuilder.kDoctor() {
    composable(route = Route) {
        KDoctorScreen()
    }
}

@Composable
fun KDoctorScreen() {
    FullCustomTemplate {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor.GrayEvent.color)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(64.dp)
            ) {
                Tag(data = ToolsTag)
                Spacer(modifier = Modifier.height(48.dp))
                LargeContentText(
                    text = "KDoctor",
                    fontWeight = FontWeight.Medium,
                )
                Spacer(modifier = Modifier.height(8.dp))
                SmallContentText(text = "Command-line tool that helps to set up the environment for Kotlin Multiplatform Mobile app development.")
                Spacer(modifier = Modifier.weight(1f))
                SmallContentText(text = KDoctorWebUrl)
            }
            Box(modifier = Modifier.weight(2f)) {
                KDoctorWebContent()
            }
        }
    }
}

@Composable
private fun KDoctorWebContent() {
    val state = rememberWebViewState(KDoctorWebUrl)
    Box(modifier = Modifier.fillMaxSize()) {
        WebView(
            modifier = Modifier.fillMaxSize(),
            state = state,
        )
    }
}

@Preview
@Composable
fun KDoctorScreenPreview() {
    MaterialTheme {
        KDoctorScreen()
    }
}
