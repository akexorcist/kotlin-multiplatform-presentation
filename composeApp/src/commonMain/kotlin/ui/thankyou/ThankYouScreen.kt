package ui.thankyou

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.component.template.DefaultTemplate
import ui.component.template.FullCustomTemplate
import ui.navigation.Screen

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
