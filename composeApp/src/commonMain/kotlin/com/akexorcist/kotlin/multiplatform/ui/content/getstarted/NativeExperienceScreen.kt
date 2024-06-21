package com.akexorcist.kotlin.multiplatform.ui.content.getstarted

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.ContentText
import com.akexorcist.kotlin.multiplatform.ui.component.TitleText
import com.akexorcist.kotlin.multiplatform.ui.component.template.CustomContentItem
import com.akexorcist.kotlin.multiplatform.ui.component.template.MultipleCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.GetStartedTag
import com.akexorcist.kotlin.multiplatform.ui.extension.gradientTint
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.BackgroundColor
import com.akexorcist.kotlin.multiplatform.ui.theme.GradientColor
import com.akexorcist.kotlin.multiplatform.ui.theme.scaledDp

private val Route = Screen.NativeExperience.name

fun NavController.navigateToNativeExperience() {
    navigate(Route)
}

fun NavGraphBuilder.nativeExperience() {
    composable(route = Route) {
        NativeExperienceScreen()
    }
}

@Composable
fun NativeExperienceScreen() {
    MultipleCustomContentTemplate(
        contents = listOf(
            CustomContentItem(
                title = "",
                description = "",
                content = {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        TitleText(
                            modifier = Modifier.gradientTint(GradientColor.BlueRed),
                            text = "Native",
                            fontWeight = FontWeight.Bold,
                        )
                        Spacer(modifier = Modifier.height(32.scaledDp()))
                        ContentText(text = "• Best user experience")
                        Spacer(modifier = Modifier.height(16.scaledDp()))
                        ContentText(text = "• Great app performance")
                        Spacer(modifier = Modifier.height(16.scaledDp()))
                        ContentText(text = "• Leverage full platform capabilities")
                    }
                },
            ),
            CustomContentItem(
                title = "",
                description = "",
                content = {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        TitleText(
                            modifier = Modifier.gradientTint(GradientColor.BlueRed),
                            text = "Cross-platform",
                            fontWeight = FontWeight.Bold,
                        )
                        Spacer(modifier = Modifier.height(32.scaledDp()))
                        ContentText(text = "• Same code for different platforms")
                        Spacer(modifier = Modifier.height(16.scaledDp()))
                        ContentText(text = "• Consistent behavior across platforms")
                        Spacer(modifier = Modifier.height(16.scaledDp()))
                        ContentText(text = "• Fewer bugs")
                    }
                },
            ),
        ),
        tag = GetStartedTag,
    )
}

@Preview
@Composable
fun NativeExperienceScreenPreview() {
    MaterialTheme {
        NativeExperienceScreen()
    }
}
