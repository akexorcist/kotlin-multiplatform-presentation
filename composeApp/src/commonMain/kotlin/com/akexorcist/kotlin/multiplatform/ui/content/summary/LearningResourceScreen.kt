package com.akexorcist.kotlin.multiplatform.ui.content.summary

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.ContentText
import com.akexorcist.kotlin.multiplatform.ui.component.LargeContentText
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.SummaryTag
import com.akexorcist.kotlin.multiplatform.ui.content.library.LibraryContent
import com.akexorcist.kotlin.multiplatform.ui.extension.gradientTint
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.GradientColor

private val Route = Screen.LearningResource.name

fun NavController.navigateToLearningResource() {
    navigate(Route)
}

fun NavGraphBuilder.learningResource() {
    composable(route = Route) {
        LearningResourceScreen()
    }
}

@Composable
fun LearningResourceScreen() {
    DefaultCustomContentTemplate(
        title = "Learning Resource",
        tag = SummaryTag,
    ) {
        Column {
            Spacer(modifier = Modifier.height(32.dp))
            LargeContentText(
                modifier = Modifier.gradientTint(GradientColor.BlueRed),
                text = "Kotlin Multiplatform",
                fontWeight = FontWeight.Medium,
            )
            Spacer(modifier = Modifier.height(4.dp))
            ContentText(
                text = "www.jetbrains.com/kotlin-multiplatform",
                fontFamily = FontFamily.Monospace,
            )
            Spacer(modifier = Modifier.height(64.dp))
            LargeContentText(
                modifier = Modifier.gradientTint(GradientColor.BlueRed),
                text = "Compose Multiplatform",
                fontWeight = FontWeight.Medium,
            )
            Spacer(modifier = Modifier.height(4.dp))
            ContentText(
                text = "www.jetbrains.com/lp/compose-multiplatform",
                fontFamily = FontFamily.Monospace,
            )
        }
    }
}

@Preview
@Composable
fun LearningResourceScreenPreview() {
    MaterialTheme {
        LearningResourceScreen()
    }
}
