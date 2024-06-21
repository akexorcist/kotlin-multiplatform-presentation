package com.akexorcist.kotlin.multiplatform.ui.content.getstarted

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.ContentText
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.GetStartedTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.scaledDp
import kotlinmultiplatform.composeapp.generated.resources.Res
import kotlinmultiplatform.composeapp.generated.resources.background_decoration
import kotlinmultiplatform.composeapp.generated.resources.image_platform_specific_code
import org.jetbrains.compose.resources.painterResource

private val Route = Screen.PlatformSpecificCode.name

fun NavController.navigateToPlatformSpecificCode() {
    navigate(Route)
}

fun NavGraphBuilder.platformSpecificCode() {
    composable(route = Route) {
        PlatformSpecificCodeScreen()
    }
}

@Composable
fun PlatformSpecificCodeScreen() {
    DefaultCustomContentTemplate(
        title = "Platform-specific Code",
        tag = GetStartedTag,
    ) {
        Row {
            ContentText(
                modifier = Modifier.weight(1f),
                text = "Expected and actual declarations, the language mechanism to access platform-specific APIs while developing common logic."
            )
            Spacer(modifier = Modifier.width(64.scaledDp()))
            Image(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight(),
                painter = painterResource(Res.drawable.image_platform_specific_code),
                contentDescription = "Platform-specific Code",
            )
        }
    }
}

@Preview
@Composable
fun PlatformSpecificCodeScreenPreview() {
    MaterialTheme {
        PlatformSpecificCodeScreen()
    }
}
