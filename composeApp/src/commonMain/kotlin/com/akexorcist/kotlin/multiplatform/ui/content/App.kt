package com.akexorcist.kotlin.multiplatform.ui.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

import com.akexorcist.kotlin.multiplatform.ui.content.aboutkotlin.aboutKotlin
import com.akexorcist.kotlin.multiplatform.ui.content.aboutkotlin.navigateToAboutKotlin
import com.akexorcist.kotlin.multiplatform.ui.content.cameraviewfinder.cameraViewFinder
import com.akexorcist.kotlin.multiplatform.ui.content.cameraviewfinder.navigateToCameraViewFinder
import com.akexorcist.kotlin.multiplatform.ui.content.introduction.introduction
import com.akexorcist.kotlin.multiplatform.ui.content.introduction.navigateToIntroduction
import com.akexorcist.kotlin.multiplatform.ui.content.maps.googleMaps
import com.akexorcist.kotlin.multiplatform.ui.content.maps.navigateToGoogleMaps
import com.akexorcist.kotlin.multiplatform.ui.navigation.NavigationBar
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.navigation.ScreenNavigationState
import com.akexorcist.kotlin.multiplatform.ui.content.thankyou.navigateToThankYou
import com.akexorcist.kotlin.multiplatform.ui.content.thankyou.thankYou
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
            Screen.GoogleMaps -> navController.navigateToGoogleMaps()
            Screen.CameraViewFinder -> navController.navigateToCameraViewFinder()
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
                    onGoToFirstClicked = { screenNavigationState.first() },
                    onGoToLastClicked = { screenNavigationState.last() },
                )
            },
            content = {
                NavHost(
                    navController = navController,
                    startDestination = currentScreen.name,
                ) {
                    introduction()
                    aboutKotlin()
                    googleMaps()
                    cameraViewFinder()
                    thankYou()
                }
            }
        )
    }
}

@Composable
fun AppScaffold(
    modifier: Modifier = Modifier,
    navigationBar: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    Box(modifier = modifier) {
        content()
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End,
        ) {
            navigationBar()
            Spacer(Modifier.width(80.dp))
        }
    }
}
