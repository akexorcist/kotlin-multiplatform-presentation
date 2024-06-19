package com.akexorcist.kotlin.multiplatform.ui.content.getstarted

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultTemplate
import com.akexorcist.kotlin.multiplatform.ui.component.template.SectionTitleTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.GetStartedTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen

private val Route = Screen.GetStartedWithDemo.name

fun NavController.navigateToGetStartedWithDemo() {
    navigate(Route)
}

fun NavGraphBuilder.getStartedWithDemo() {
    composable(route = Route) {
        GetStartedWithDemoScreen()
    }
}

@Composable
fun GetStartedWithDemoScreen() {
    SectionTitleTemplate(
        title = "Demonstrate",
        description = "Talk is cheap. Show me the code",
        tag = GetStartedTag,
    )
}

@Preview
@Composable
fun GetStartedWithDemoScreenPreview() {
    MaterialTheme {
        GetStartedWithDemoScreen()
    }
}
