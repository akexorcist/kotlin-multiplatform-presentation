package com.akexorcist.kotlin.multiplatform.ui.content.platform

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.LargeCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.PlatformTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.scaledDp
import kotlinmultiplatform.composeapp.generated.resources.*
import kotlinmultiplatform.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

private val Route = Screen.PlatformAndroid.name

fun NavController.navigateToPlatformAndroid() {
    navigate(Route)
}

fun NavGraphBuilder.platformAndroid() {
    composable(route = Route) {
        PlatformAndroidScreen()
    }
}

@Composable
fun PlatformAndroidScreen() {
    LargeCustomContentTemplate(
        title = "Kotlin/Android",
        description = """
            Android mobile development has been Kotlin-first since Google I/O in 2019.
            
            70% of developers whose primary language is Kotlin say that Kotlin makes them more productive.
        """.trimIndent(),
        tag = PlatformTag,
    ) {
        Box(modifier = Modifier.padding(horizontal = 32.scaledDp())) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(Res.drawable.image_platform_binary_android),
                contentDescription = "Platform binary",
            )
        }
    }
}

@Preview
@Composable
fun PlatformAndroidScreenPreview() {
    MaterialTheme {
        PlatformAndroidScreen()
    }
}
