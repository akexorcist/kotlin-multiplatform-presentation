package com.akexorcist.kotlin.multiplatform.ui.content.getstarted

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
import com.akexorcist.kotlin.multiplatform.ui.content.GetStartedTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.BackgroundColor
import com.akexorcist.kotlin.multiplatform.ui.theme.scaledDp

private val Route = Screen.KotlinMultiplatformWizard.name
private const val KotlinMultiplatformWizardWebUrl = "kmp.jetbrains.com"

fun NavController.navigateToKotlinMultiplatformWizard() {
    navigate(Route)
}

fun NavGraphBuilder.kotlinMultiplatformWizard() {
    composable(route = Route) {
        KotlinMultiplatformWizardScreen()
    }
}

@Composable
fun KotlinMultiplatformWizardScreen() {
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
                Tag(data = GetStartedTag)
                Spacer(modifier = Modifier.height(48.scaledDp()))
                LargeContentText(
                    text = "Kotlin Multiplatform Wizard",
                    fontWeight = FontWeight.Medium,
                )
                Spacer(modifier = Modifier.height(8.scaledDp()))
                SmallContentText(text = "Tools to help you create projects for Kotlin Multiplatform.")
                Spacer(modifier = Modifier.weight(1f))
                SmallContentText(
                    text = KotlinMultiplatformWizardWebUrl,
                    fontFamily = FontFamily.Monospace,
                )
            }
            Box(modifier = Modifier.weight(2f)) {
                WebViewContent(url = "https://$KotlinMultiplatformWizardWebUrl")
            }
        }
    }
}

@Preview
@Composable
fun KotlinMultiplatformWizardScreenPreview() {
    MaterialTheme {
        KotlinMultiplatformWizardScreen()
    }
}
