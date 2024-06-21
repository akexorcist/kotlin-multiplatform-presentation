package com.akexorcist.kotlin.multiplatform.ui.content.summary

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.ContentText
import com.akexorcist.kotlin.multiplatform.ui.component.SmallContentText
import com.akexorcist.kotlin.multiplatform.ui.component.Tag
import com.akexorcist.kotlin.multiplatform.ui.component.template.FullCustomTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.SummaryTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.BackgroundColor
import com.akexorcist.kotlin.multiplatform.ui.theme.scaledDp
import com.multiplatform.webview.web.WebView
import com.multiplatform.webview.web.rememberWebViewState
import kotlinmultiplatform.composeapp.generated.resources.Res
import kotlinmultiplatform.composeapp.generated.resources.image_slide_resource_qr
import org.jetbrains.compose.resources.vectorResource

private val Route = Screen.SlideResource.name
private const val SlideResourceWebUrl = "github.com/akexorcist/kotlin-multiplatform-presentation"

fun NavController.navigateToSlideResource() {
    navigate(Route)
}

fun NavGraphBuilder.slideResource() {
    composable(route = Route) {
        SlideResourceScreen()
    }
}

@Composable
fun SlideResourceScreen() {
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
                Tag(data = SummaryTag)
                Spacer(modifier = Modifier.height(48.scaledDp()))
                ContentText(
                    text = "This presentation slide built with Kotlin Multiplatform and Compose Multiplatform.",
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .aspectRatio(1f)
                        .offset(x = (-14).scaledDp()),
                    imageVector = vectorResource(Res.drawable.image_slide_resource_qr),
                    contentDescription = "Presentation slide's QR",
                )
                Spacer(modifier = Modifier.height(8.scaledDp()))
                SmallContentText(
                    text = SlideResourceWebUrl,
                )
            }
            Box(modifier = Modifier.weight(2f)) {
                SlideResourceWebContent()
            }
        }
    }
}

@Composable
private fun SlideResourceWebContent() {
    val state = rememberWebViewState(SlideResourceWebUrl)
    Box(modifier = Modifier.fillMaxSize()) {
        WebView(
            modifier = Modifier.fillMaxSize(),
            state = state,
        )
    }
}

@Preview
@Composable
fun SlideResourceScreenPreview() {
    MaterialTheme {
        SlideResourceScreen()
    }
}
