package com.akexorcist.kotlin.multiplatform.ui.content.preview

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.Tag
import com.akexorcist.kotlin.multiplatform.ui.component.TagData
import com.akexorcist.kotlin.multiplatform.ui.component.template.HighlightStatisticTemplate
import com.akexorcist.kotlin.multiplatform.ui.component.template.MultipleContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.component.template.TitleTemplate
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.GradientColor

private val Route = Screen.MultipleContentTemplate.name

fun NavController.navigateToMultipleContentTemplate() {
    navigate(Route)
}

fun NavGraphBuilder.multipleContentTemplate() {
    composable(route = Route) {
        MultipleContentTemplateScreen()
    }
}

@Composable
fun MultipleContentTemplateScreen() {
    MultipleContentTemplate(
        title = "Headline goes here",
        contents = listOf(
            "This is a subhead" to "This is body copy. Connect with fellow developers and startups in your area, hear from industry experts, share your skills, and learn new ones.",
            "This is a subhead" to "This is body copy. Bringing developers together in-person and online. Stay in the know about upcoming events."
        ),
        tag = TagData(
            text = "Section #",
            background = GradientColor.BlueRed,
        ),
    )
}