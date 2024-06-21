package com.akexorcist.kotlin.multiplatform.ui.content.summary

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.ContentText
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.SummaryTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.scaledDp
import kotlinmultiplatform.composeapp.generated.resources.Res
import kotlinmultiplatform.composeapp.generated.resources.image_summary_kotlin_multiplatform
import org.jetbrains.compose.resources.painterResource

private val Route = Screen.Summary1.name

fun NavController.navigateToSummary1() {
    navigate(Route)
}

fun NavGraphBuilder.summary1() {
    composable(route = Route) {
        Summary1Screen()
    }
}

@Composable
fun Summary1Screen() {
    DefaultCustomContentTemplate(
        title = "Kotlin Multiplatform",
        tag = SummaryTag,
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.weight(2f)) {
                ContentText(text = "Simplify the development of cross-platform projects while retaining the flexibility and benefits of native programming.")
                Spacer(modifier = Modifier.height(64.scaledDp()))
                ContentText(
                    text = "Use cases",
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(8.scaledDp()))
                ContentText(text = "• Android and iOS applications")
                Spacer(modifier = Modifier.height(8.scaledDp()))
                ContentText(text = "• Multiplatform libraries")
                Spacer(modifier = Modifier.height(8.scaledDp()))
                ContentText(text = "• Desktop applications")
            }
            Column(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .offset(y = (-128).scaledDp()),
                    painter = painterResource(Res.drawable.image_summary_kotlin_multiplatform),
                    contentDescription = "Kotlin",
                    contentScale = ContentScale.Fit,
                )
            }
        }
    }
}

@Preview
@Composable
fun Summary1ScreenPreview() {
    MaterialTheme {
        Summary1Screen()
    }
}
