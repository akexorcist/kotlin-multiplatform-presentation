package com.akexorcist.kotlin.multiplatform.ui.content.limitation

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
import com.akexorcist.kotlin.multiplatform.ui.component.*
import com.akexorcist.kotlin.multiplatform.ui.component.template.FullCustomTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.LimitationTag
import com.akexorcist.kotlin.multiplatform.ui.extension.gradientTint
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.BackgroundColor
import com.akexorcist.kotlin.multiplatform.ui.theme.GradientColor
import com.akexorcist.kotlin.multiplatform.ui.theme.scaled
import com.akexorcist.kotlin.multiplatform.ui.theme.scaledDp

private val Route = Screen.PreviewTools.name

private val previewItems = listOf(
    Triple(
        "Android Studio / IntelliJ IDEA",
        "androidMain",
        "@androidx.compose.ui.tooling.preview.Preview",
    ),
    Triple(
        "Android Studio / IntelliJ IDEA",
        "desktopMain",
        "@androidx.compose.desktop.ui.tooling.preview.Preview",
    ),
    Triple(
        "Fleet",
        "commonMain / androidMain / desktopMain",
        "@org.jetbrains.compose.ui.tooling.preview.Preview",
    ),
)

fun NavController.navigateToPreviewTools() {
    navigate(Route)
}

fun NavGraphBuilder.previewTools() {
    composable(route = Route) {
        PreviewToolsScreen()
    }
}

@Composable
fun PreviewToolsScreen() {
    FullCustomTemplate {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor.GrayEvent.color)
                .padding(
                    vertical = VerticalScreenPadding.scaled(),
                    horizontal = HorizontalScreenPadding.scaled(),
                ),
        ) {
            Tag(data = LimitationTag)
            Spacer(modifier = Modifier.height(48.scaledDp()))
            TitleText(
                modifier = Modifier.fillMaxWidth(),
                text = "Preview in Compose Multiplatform",
            )
            Spacer(modifier = Modifier.height(32.scaledDp()))
            previewItems.forEachIndexed { index, (ide, module, preview) ->
                PreviewTypeContent(
                    ide = ide,
                    module = module,
                    preview = preview,
                )
                if (index != previewItems.lastIndex) {
                    Spacer(modifier = Modifier.height(48.scaledDp()))
                }
            }
        }
    }
}

@Composable
private fun PreviewTypeContent(
    ide: String,
    module: String,
    preview: String,
) {
    Column(modifier = Modifier.gradientTint(GradientColor.BlueRed)) {
        SmallContentText(
            text = ide,
            fontWeight = FontWeight.Medium,
        )
        SmallContentText(
            modifier = Modifier.offset(y = (-4).scaledDp()),
            text = module,
            fontWeight = FontWeight.Medium,
        )
    }
    ContentText(
        text = preview,
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Medium,
    )
}

@Preview
@Composable
fun PreviewToolsScreenPreview() {
    MaterialTheme {
        PreviewToolsScreen()
    }
}
