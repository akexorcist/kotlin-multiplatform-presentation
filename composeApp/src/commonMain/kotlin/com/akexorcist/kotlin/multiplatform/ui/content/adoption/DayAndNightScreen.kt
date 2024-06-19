package com.akexorcist.kotlin.multiplatform.ui.content.adoption

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akexorcist.kotlin.multiplatform.dayandnight.DayAndNightContainer
import com.akexorcist.kotlin.multiplatform.dayandnight.DayAndNightSwitch
import com.akexorcist.kotlin.multiplatform.ui.component.TagData
import com.akexorcist.kotlin.multiplatform.ui.component.template.RightCustomContentTemplate
import com.akexorcist.kotlin.multiplatform.ui.content.AdoptionTag
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.theme.GradientColor

private val Route = Screen.DayAndNight.name

fun NavController.navigateToDayAndNight() {
    navigate(Route)
}

fun NavGraphBuilder.dayAndNight() {
    composable(route = Route) {
        DayAndNightScreen()
    }
}

@Composable
fun DayAndNightScreen() {
    var selected by remember { mutableStateOf(true) }
    RightCustomContentTemplate(
        title = "Day & Night Switch",
        description = "Built with Compose Multiplatform",
        tag = AdoptionTag,
        content = {
            DayAndNightContainer(
                modifier = Modifier.fillMaxSize(),
                selected = selected,
            ) {
                DayAndNightSwitch(
                    modifier = Modifier.scale(2f),
                    selected = selected,
                    onSwitchToggle = { selected = !selected },
                )
            }
        },
    )
}

@Preview
@Composable
fun DayAndNightScreenPreview() {
    MaterialTheme {
        DayAndNightScreen()
    }
}
