package com.akexorcist.kotlin.multiplatform.ui.content.summary

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.ContentText
import com.akexorcist.kotlin.multiplatform.ui.component.HorizontalScreenPadding
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.SummaryTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import kotlinmultiplatform.composeapp.generated.resources.Res
import kotlinmultiplatform.composeapp.generated.resources.image_summary_compose_multiplatform
import kotlinmultiplatform.composeapp.generated.resources.image_summary_compose_multiplatform_code
import kotlinmultiplatform.composeapp.generated.resources.image_summary_kotlin_multiplatform
import org.jetbrains.compose.resources.painterResource

private val Route = Screen.Summary2.name

fun NavController.navigateToSummary2() {
    navigate(Route)
}

fun NavGraphBuilder.summary2() {
    composable(route = Route) {
        Summary2Screen()
    }
}

@Composable
fun Summary2Screen() {
    DefaultCustomContentTemplate(
        title = "Kotlin Multiplatform",
        tag = SummaryTag,
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.weight(2f)) {
                ContentText(text = "Develop stunning shared UIs for Android, iOS, desktop, and web.")
                Spacer(modifier = Modifier.height(64.dp))
                Image(
                    modifier = Modifier.width(600.dp).offset(x = (-8).dp),
                    painter = painterResource(Res.drawable.image_summary_compose_multiplatform_code),
                    contentDescription = "Code",
                )
            }
            Column(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxHeight()
                    .padding(horizontal = HorizontalScreenPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .offset(y = (-128).dp),
                    painter = painterResource(Res.drawable.image_summary_compose_multiplatform),
                    contentDescription = "Kotlin",
                    contentScale = ContentScale.Fit,
                )
            }
        }
    }
}

@Preview
@Composable
fun Summary2ScreenPreview() {
    MaterialTheme {
        Summary2Screen()
    }
}