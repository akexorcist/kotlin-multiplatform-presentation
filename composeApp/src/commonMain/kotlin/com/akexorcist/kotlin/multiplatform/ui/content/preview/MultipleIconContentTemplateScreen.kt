package com.akexorcist.kotlin.multiplatform.ui.content.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.TagData
import com.akexorcist.kotlin.multiplatform.ui.component.template.MultipleIconContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.ContentColor
import com.akexorcist.kotlin.multiplatform.ui.theme.GradientColor
import com.akexorcist.kotlin.multiplatform.ui.theme.scaledDp

private val Route = Screen.MultipleIconContentTemplate.name

fun NavController.navigateToMultipleIconContentTemplate() {
    navigate(Route)
}

fun NavGraphBuilder.multipleIconContentTemplate() {
    composable(route = Route) {
        MultipleIconContentTemplateScreen()
    }
}

@Composable
fun MultipleIconContentTemplateScreen() {
    MultipleIconContentTemplate(
        contents = listOf(
            Triple(
                "Lorem ipsum",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
            ) {
                Spacer(modifier = Modifier.size(60.scaledDp()).background(ContentColor.Blue.color))
            },
            Triple(
                "Lorem ipsum",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
            ) {
                Spacer(modifier = Modifier.size(60.scaledDp()).background(ContentColor.Blue.color))
            },
        ),
        tag = TagData(
            text = "Section #",
            background = GradientColor.BlueRed,
        ),
    )
}
