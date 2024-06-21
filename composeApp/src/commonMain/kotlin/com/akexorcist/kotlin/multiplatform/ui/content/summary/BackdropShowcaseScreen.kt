package com.akexorcist.kotlin.multiplatform.ui.content.summary

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.ContentText
import com.akexorcist.kotlin.multiplatform.ui.component.LargeContentText
import com.akexorcist.kotlin.multiplatform.ui.component.SmallContentText
import com.akexorcist.kotlin.multiplatform.ui.component.Tag
import com.akexorcist.kotlin.multiplatform.ui.component.template.FullCustomTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.SummaryTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.BackgroundColor
import com.akexorcist.kotlin.multiplatform.ui.theme.scaledDp
import kotlinmultiplatform.composeapp.generated.resources.Res
import kotlinmultiplatform.composeapp.generated.resources.image_showcase_backdrop
import org.jetbrains.compose.resources.painterResource

private val Route = Screen.BackdropShowcase.name

fun NavController.navigateToBackdropShowcase() {
    navigate(Route)
}

fun NavGraphBuilder.backdropShowcase() {
    composable(route = Route) {
        BackdropShowcaseScreen()
    }
}

@Composable
fun BackdropShowcaseScreen() {
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
                LargeContentText(
                    text = "Backdrop",
                    fontWeight = FontWeight.Medium,
                )
                Spacer(modifier = Modifier.height(8.scaledDp()))
                ContentText(text = "Video and audio projection app for your streaming content on macOS")
                Spacer(modifier = Modifier.weight(1f))
                SmallContentText(
                    text = "github.com/akexorcist/backdrop",
                    fontFamily = FontFamily.Monospace,
                )
            }
            Box(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    modifier = Modifier.clip(RoundedCornerShape(8.scaledDp())),
                    painter = painterResource(Res.drawable.image_showcase_backdrop),
                    contentDescription = "Backdrop app",
                )
            }
            Spacer(modifier = Modifier.width(48.scaledDp()))
        }
    }
}

@Preview
@Composable
fun BackdropShowcaseScreenPreview() {
    MaterialTheme {
        BackdropShowcaseScreen()
    }
}
