package com.akexorcist.kotlin.multiplatform.ui.content.preview

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.FullCustomTemplate
import com.akexorcist.kotlin.multiplatform.ui.component.template.TitleTemplate
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen

private val Route = Screen.FullCustomTemplate.name

fun NavController.navigateToFullCustomTemplate() {
    navigate(Route)
}

fun NavGraphBuilder.fullCustomTemplate() {
    composable(route = Route) {
        FullCustomTemplateScreen()
    }
}

@Composable
fun FullCustomTemplateScreen() {
    FullCustomTemplate {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Lorem ipsum",
        )
    }
}
