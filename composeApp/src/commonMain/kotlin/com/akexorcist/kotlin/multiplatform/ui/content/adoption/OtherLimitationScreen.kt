package com.akexorcist.kotlin.multiplatform.ui.content.adoption

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.DefaultTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.AdoptionTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen

private val Route = Screen.OtherLimitation.name

fun NavController.navigateToOtherLimitation() {
    navigate(Route)
}

fun NavGraphBuilder.otherLimitation() {
    composable(route = Route) {
        OtherLimitationScreen()
    }
}

@Composable
fun OtherLimitationScreen() {
    DefaultTemplate(
        title = "Other Limitation",
        content = "",
        tag = AdoptionTag,
    )
}

@Preview
@Composable
fun OtherLimitationScreenPreview() {
    MaterialTheme {
        OtherLimitationScreen()
    }
}
