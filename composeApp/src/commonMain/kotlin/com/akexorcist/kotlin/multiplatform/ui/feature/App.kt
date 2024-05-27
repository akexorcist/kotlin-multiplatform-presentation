package com.akexorcist.kotlin.multiplatform.ui.feature

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

import com.akexorcist.kotlin.multiplatform.ui.feature.aboutkotlin.aboutKotlin
import com.akexorcist.kotlin.multiplatform.ui.feature.aboutkotlin.navigateToAboutKotlin
import com.akexorcist.kotlin.multiplatform.ui.feature.introduction.introduction
import com.akexorcist.kotlin.multiplatform.ui.feature.introduction.navigateToIntroduction
import com.akexorcist.kotlin.multiplatform.ui.navigation.NavigationBar
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.navigation.ScreenNavigationState
import com.akexorcist.kotlin.multiplatform.ui.feature.thankyou.navigateToThankYou
import com.akexorcist.kotlin.multiplatform.ui.feature.thankyou.thankYou
import com.akexorcist.kotlin.multiplatform.ui.theme.BackgroundColor

@Composable
fun App(
    screenNavigationState: ScreenNavigationState,
) {
    val currentScreen = screenNavigationState.currentScreen
    val navController = rememberNavController()

    LaunchedEffect(currentScreen) {
        when (currentScreen) {
            Screen.Introduction -> navController.navigateToIntroduction()
            Screen.AboutKotlin -> navController.navigateToAboutKotlin()
            Screen.ThankYou -> navController.navigateToThankYou()
        }
    }

    MaterialTheme {
        AppScaffold(
            modifier = Modifier.background(BackgroundColor.White.color),
            navigationBar = {
                NavigationBar(
                    currentScreen = currentScreen,
                    onPreviousClicked = { screenNavigationState.back() },
                    onNextClicked = { screenNavigationState.next() },
                    onGoToFirstClicked ={ screenNavigationState.first() },
                    onGoToLastClicked ={ screenNavigationState.last() },
                )
            },
            content = {
                NavHost(
                    navController = navController,
                    startDestination = currentScreen.name,
                ) {
                    introduction()
                    aboutKotlin()
                    thankYou()
                }
            }
        )
    }
}

//@Composable
//private fun Demo() {
//    var showContent by remember { mutableStateOf(false) }
//    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//        Button(onClick = { showContent = !showContent }) {
//            Text1("Click me!")
//        }
//        AnimatedVisibility(showContent) {
//            val greeting = remember { Greeting().greet() }
//            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                Image(painterResource(Res.drawable.compose_multiplatform), null)
//                Text1("Compose: $greeting")
//            }
//        }
//    }
//}

@Composable
fun AppScaffold(
    modifier: Modifier = Modifier,
    navigationBar: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    Box(modifier = modifier) {
        content()
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.BottomEnd,
        ) {
            navigationBar()
        }
    }
}
