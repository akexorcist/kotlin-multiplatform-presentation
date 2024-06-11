package com.akexorcist.kotlin.multiplatform.ui.content.preview

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.TagData
import com.akexorcist.kotlin.multiplatform.ui.component.template.SectionTitleTemplate
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.GradientColor

private val Route = Screen.SectionTitleTemplate.name

fun NavController.navigateToSectionTitleTemplate() {
    navigate(Route)
}

fun NavGraphBuilder.sectionTitleTemplate() {
    composable(route = Route) {
        SectionTitleTemplateScreen()
    }
}

@Composable
fun SectionTitleTemplateScreen() {
    SectionTitleTemplate(
        title = "A section title should not exceed two lines",
        description = "Supporting text if needed",
        tag = TagData(
            text = "Title 1",
            background = GradientColor.BlueRed,
        )
    )
}
