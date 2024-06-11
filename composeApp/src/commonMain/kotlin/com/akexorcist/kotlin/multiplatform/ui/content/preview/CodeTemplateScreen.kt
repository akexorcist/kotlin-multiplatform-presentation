package com.akexorcist.kotlin.multiplatform.ui.content.preview

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.CodeTemplate
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen

private val Route = Screen.CodeTemplate.name

fun NavController.navigateToCodeTemplate() {
    navigate(Route)
}

fun NavGraphBuilder.codeTemplate() {
    composable(route = Route) {
        CodeTemplateScreen()
    }
}

@Composable
fun CodeTemplateScreen() {
    CodeTemplate(
        code = "<html></html>"
    )
}
