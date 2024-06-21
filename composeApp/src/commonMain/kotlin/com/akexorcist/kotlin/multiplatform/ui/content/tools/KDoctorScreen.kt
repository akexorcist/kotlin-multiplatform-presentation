package com.akexorcist.kotlin.multiplatform.ui.content.tools

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.LargeContentText
import com.akexorcist.kotlin.multiplatform.ui.component.SmallContentText
import com.akexorcist.kotlin.multiplatform.ui.component.Tag
import com.akexorcist.kotlin.multiplatform.ui.component.WebViewContent
import com.akexorcist.kotlin.multiplatform.ui.component.template.FullCustomTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.ToolsTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.BackgroundColor
import com.akexorcist.kotlin.multiplatform.ui.theme.scaledDp

private val Route = Screen.KDoctor.name
private const val KDoctorWebUrl = "github.com/Kotlin/kdoctor"

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
                    .padding(64.scaledDp())
            ) {
                Tag(data = ToolsTag)
                Spacer(modifier = Modifier.height(48.scaledDp()))
                LargeContentText(
                    text = "KDoctor",
                    fontWeight = FontWeight.Medium,
                )
                Spacer(modifier = Modifier.height(8.scaledDp()))
                SmallContentText(text = "Command-line tool that helps to set up the environment for Kotlin Multiplatform Mobile app development.")
                Spacer(modifier = Modifier.weight(1f))
                SmallContentText(
                    text = KDoctorWebUrl,
                    fontFamily = FontFamily.Monospace,
                )
            }
            Box(modifier = Modifier.weight(2f)) {
                WebViewContent(url = KDoctorWebUrl)
            }
        }
    }
}

@Preview
@Composable
fun KDoctorScreenPreview() {
    MaterialTheme {
        KDoctorScreen()
    }
}
