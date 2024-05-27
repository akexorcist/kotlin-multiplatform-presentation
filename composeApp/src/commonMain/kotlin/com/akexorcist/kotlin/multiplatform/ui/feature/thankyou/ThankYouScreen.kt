package com.akexorcist.kotlin.multiplatform.ui.feature.thankyou

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.component.template.FullCustomTemplate
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen

fun NavController.navigateToThankYou() {
    navigate(Screen.ThankYou.name)
}

fun NavGraphBuilder.thankYou() {
    composable(route = Screen.ThankYou.name) {
        ThankYouScreen()
    }
}

@Composable
fun ThankYouScreen() {
    FullCustomTemplate {
        Text(text = "Thank You")
    }
}

@Preview
@Composable
fun ThankYouScreenPreview() {
    MaterialTheme {
        ThankYouScreen()
    }
}
