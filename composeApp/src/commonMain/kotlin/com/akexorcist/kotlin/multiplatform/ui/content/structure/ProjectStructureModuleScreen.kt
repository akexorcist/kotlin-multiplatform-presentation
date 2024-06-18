package com.akexorcist.kotlin.multiplatform.ui.content.structure

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.ui.component.template.RightCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.component.template.RightFrameTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.StructureTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.GradientColor
import kotlinmultiplatform.composeapp.generated.resources.*
import kotlinmultiplatform.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

private val Route = Screen.ProjectStructureModule.name

fun NavController.navigateToProjectStructureModule() {
    navigate(Route)
}

fun NavGraphBuilder.projectStructureModule() {
    composable(route = Route) {
        ProjectStructureModuleScreen()
    }
}

@Composable
fun ProjectStructureModuleScreen() {
    RightFrameTemplate(
        title = "Kotlin Multiplatform project structure",
        description = """
            Kotlin code shared among platforms is typically located in the commonMain directory.
            
            The location of code files is important, as it affects the list of platforms to which this code is compiled.
        """.trimIndent(),
        tag = StructureTag,
        frameColor = GradientColor.YellowRed,
    ) {
        Image(
            modifier = Modifier.fillMaxSize().background(color = Color(0xFF2B2D30)),
            painter = painterResource(Res.drawable.image_project_structure_module),
            contentDescription = "Share piece of logic example",
        )
    }
}

@Preview
@Composable
fun ProjectStructureModuleScreenPreview() {
    MaterialTheme {
        ProjectStructureModuleScreen()
    }
}
