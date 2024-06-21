package com.akexorcist.kotlin.multiplatform.ui.content

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

import com.akexorcist.kotlin.multiplatform.ui.content.aboutkotlin.aboutKotlin
import com.akexorcist.kotlin.multiplatform.ui.content.aboutkotlin.navigateToAboutKotlin
import com.akexorcist.kotlin.multiplatform.ui.content.adoption.*
import com.akexorcist.kotlin.multiplatform.ui.content.camera.cameraViewFinder
import com.akexorcist.kotlin.multiplatform.ui.content.camera.navigateToCameraViewFinder
import com.akexorcist.kotlin.multiplatform.ui.content.compose.*
import com.akexorcist.kotlin.multiplatform.ui.content.cover.cover
import com.akexorcist.kotlin.multiplatform.ui.content.cover.navigateToCover
import com.akexorcist.kotlin.multiplatform.ui.content.adoption.dayAndNight
import com.akexorcist.kotlin.multiplatform.ui.content.adoption.navigateToDayAndNight
import com.akexorcist.kotlin.multiplatform.ui.content.getstarted.*
import com.akexorcist.kotlin.multiplatform.ui.content.introduction.*
import com.akexorcist.kotlin.multiplatform.ui.content.library.navigateToThirdPartyAllPlatformLibrary
import com.akexorcist.kotlin.multiplatform.ui.content.library.navigateToThirdPartyMobileLibrary
import com.akexorcist.kotlin.multiplatform.ui.content.library.thirdPartyAllPlatformLibrary
import com.akexorcist.kotlin.multiplatform.ui.content.library.thirdPartyMobileLibrary
import com.akexorcist.kotlin.multiplatform.ui.content.limitation.navigateToOtherLimitation
import com.akexorcist.kotlin.multiplatform.ui.content.limitation.navigateToPreviewTools
import com.akexorcist.kotlin.multiplatform.ui.content.limitation.otherLimitation
import com.akexorcist.kotlin.multiplatform.ui.content.limitation.previewTools
import com.akexorcist.kotlin.multiplatform.ui.content.maps.map
import com.akexorcist.kotlin.multiplatform.ui.content.maps.navigateToMap
import com.akexorcist.kotlin.multiplatform.ui.content.platform.*
import com.akexorcist.kotlin.multiplatform.ui.content.preview.*
import com.akexorcist.kotlin.multiplatform.ui.content.strategy.*
import com.akexorcist.kotlin.multiplatform.ui.content.structure.*
import com.akexorcist.kotlin.multiplatform.ui.content.summary.*
import com.akexorcist.kotlin.multiplatform.ui.navigation.NavigationBar
import com.akexorcist.kotlin.multiplatform.ui.navigation.Screen
import com.akexorcist.kotlin.multiplatform.ui.navigation.ScreenNavigationState
import com.akexorcist.kotlin.multiplatform.ui.content.tools.*
import com.akexorcist.kotlin.multiplatform.ui.theme.*

enum class ScreenSize {
    Default, Small,
}

@Composable
fun App(
    screenNavigationState: ScreenNavigationState,
) {
    val currentScreen = screenNavigationState.currentScreen
    val navController = rememberNavController()
    val screenSize = ScreenSize.Small

    LaunchedEffect(currentScreen) {
        when (currentScreen) {
            Screen.Cover -> navController.navigateToCover()
            Screen.IntroKotlin -> navController.navigateToIntroKotlin()
            Screen.KotlinAndAndroid -> navController.navigateToKotlinAndAndroid()
            Screen.KotlinMultiplatform -> navController.navigateToKotlinMultiplatform()
            Screen.KotlinMultiplatformLogo -> navController.navigateToKotlinMultiplatformLogo()
            Screen.PlatformSupport -> navController.navigateToPlatformSupport()
            Screen.ShareCodeStrategy -> navController.navigateToShareCodeStrategy()
            Screen.SharePartialCode -> navController.navigateToSharePartialCode()
            Screen.ShareLogicCode -> navController.navigateToShareLogicCode()
            Screen.ShareAllCode -> navController.navigateToShareAllCode()
            Screen.PlatformBinary -> navController.navigateToPlatformBinary()
            Screen.PlatformAndroid -> navController.navigateToPlatformAndroid()
            Screen.PlatformJvm -> navController.navigateToPlatformJvm()
            Screen.PlatformJs -> navController.navigateToPlatformJs()
            Screen.PlatformWasm -> navController.navigateToPlatformWasm()
            Screen.PlatformNative -> navController.navigateToPlatformNative()
            Screen.IdeForKotlinMultiplatform -> navController.navigateToIdeForKotlinMultiplatform()
            Screen.KDoctor -> navController.navigateToKDoctor()
            Screen.Gradle -> navController.navigateToGradle()
            Screen.CommonAndSpecificPlatform -> navController.navigateToCommonAndSpecificPlatform()
            Screen.ProjectStructureModule -> navController.navigateToProjectStructureModule()
            Screen.KotlinMultiplatformWizard -> navController.navigateToKotlinMultiplatformWizard()
            Screen.GetStartedWithDemo -> navController.navigateToGetStartedWithDemo()
            Screen.PlatformSpecificCode -> navController.navigateToPlatformSpecificCode()
            Screen.NativeExperience -> navController.navigateToNativeExperience()
            Screen.ComposeMultiplatformIntroduction -> navController.navigateToComposeMultiplatformIntroduction()
            Screen.ComposeMultiplatformBenefit -> navController.navigateToComposeMultiplatformBenefit()
            Screen.ComposeMultiplatformPlatform -> navController.navigateToComposeMultiplatformPlatform()
            Screen.ComposeMultiplatformRender -> navController.navigateToComposeMultiplatformRender()
            Screen.ComposeMultiplatformLimitation -> navController.navigateToComposeMultiplatformLimitation()
            Screen.KotlinMultiplatformBenefit -> navController.navigateToKotlinMultiplatformBenefit()
            Screen.ReadyForProduction -> navController.navigateToReadyForProduction()
            Screen.CameraAccess1 -> navController.navigateToCameraAccess1()
            Screen.CameraAccess2 -> navController.navigateToCameraAccess2()
            Screen.MapRendering1 -> navController.navigateToMapRendering1()
            Screen.MapRendering2 -> navController.navigateToMapRendering2()
            Screen.ThirdPartyAllPlatformLibrary -> navController.navigateToThirdPartyAllPlatformLibrary()
            Screen.ThirdPartyMobileLibrary -> navController.navigateToThirdPartyMobileLibrary()
            Screen.PreviewTools -> navController.navigateToPreviewTools()
            Screen.OtherLimitation -> navController.navigateToOtherLimitation()
            Screen.ReallyReadyForProduction -> navController.navigateToReallyReadyForProduction()
            Screen.DayAndNight -> navController.navigateToDayAndNight()
            Screen.BackdropShowcase -> navController.navigateToBackdropShowcase()
            Screen.DecisionMakingFactor -> navController.navigateToDecisionMakingFactor()
            Screen.Summary1 -> navController.navigateToSummary1()
            Screen.Summary2 -> navController.navigateToSummary2()
            Screen.LearningResource -> navController.navigateToLearningResource()
            Screen.SlideResource -> navController.navigateToSlideResource()
            Screen.ThankYou -> navController.navigateToThankYou()

            Screen.Introduction -> navController.navigateToIntroduction()
            Screen.TitleTemplate -> navController.navigateToTitleTemplate()
            Screen.SectionTitleTemplate -> navController.navigateToSectionTitleTemplate()
            Screen.DefaultTemplate -> navController.navigateToDefaultTemplate()
            Screen.RightFrameTemplate -> navController.navigateToRightFrameTemplate()
            Screen.LeftFrameTemplate -> navController.navigateToLeftFrameTemplate()
            Screen.LargeFrameTemplate -> navController.navigateToLargeFrameTemplate()
            Screen.HighlightStatisticTemplate -> navController.navigateToHighlightStatisticTemplate()
            Screen.MultipleContentTemplate -> navController.navigateToMultipleContentTemplate()
            Screen.MultipleIconContentTemplate -> navController.navigateToMultipleIconContentTemplate()
            Screen.RightCustomContentTemplate -> navController.navigateToRightCustomContentTemplate()
            Screen.FullCustomTemplate -> navController.navigateToFullCustomTemplate()
            Screen.CodeTemplate -> navController.navigateToCodeTemplate()
            Screen.CodeCustomContentTemplate -> navController.navigateToCodeCustomContent()
            Screen.ThankYouTemplate -> navController.navigateToThankYouTemplate()
            Screen.AboutKotlin -> navController.navigateToAboutKotlin()
            Screen.Map -> navController.navigateToMap()
            Screen.CameraViewFinder -> navController.navigateToCameraViewFinder()
        }
    }

    MaterialTheme(
        typography = when (screenSize) {
            ScreenSize.Default -> AppTypography.default()
            ScreenSize.Small -> AppTypography.small()
        }
    ) {
        CompositionLocalProvider(
            LocalSizeScale provides SizeScale(
                when (screenSize) {
                    ScreenSize.Default -> 1.0f
                    ScreenSize.Small -> 0.8f
                }
            ),
        ) {
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
                        modifier = Modifier.fillMaxSize(),
                        navController = navController,
                        startDestination = currentScreen.name,
                        enterTransition = { fadeIn(animationSpec = tween(300)) },
                        exitTransition = { fadeOut(animationSpec = tween(300)) },
                    ) {
                        cover()
                        introKotlin()
                        kotlinAndAndroid()
                        kotlinMultiplatform()
                        kotlinMultiplatformLogo()
                        platformSupport()
                        shareCodeStrategy()
                        sharePartialCode()
                        shareLogicCode()
                        shareAllCode()
                        platformBinary()
                        platformAndroid()
                        platformJvm()
                        platformJs()
                        platformWasm()
                        platformNative()
                        ideForKotlinMultiplatform()
                        kDoctor()
                        gradle()
                        commonAndSpecificPlatform()
                        projectStructureModule()
                        kotlinMultiplatformWizard()
                        getStartedWithDemo()
                        platformSpecificCode()
                        nativeExperience()
                        composeMultiplatformIntroduction()
                        composeMultiplatformBenefit()
                        composeMultiplatformPlatform()
                        composeMultiplatformRender()
                        composeMultiplatformLimitation()
                        kotlinMultiplatformBenefit()
                        readyForProduction()
                        cameraAccess1()
                        cameraAccess2()
                        mapRendering1()
                        mapRendering2()
                        thirdPartyAllPlatformLibrary()
                        thirdPartyMobileLibrary()
                        previewTools()
                        otherLimitation()
                        reallyReadyForProduction()
                        dayAndNight()
                        backdropShowcase()
                        decisionMakingFactor()
                        summary1()
                        summary2()
                        learningResource()
                        slideResource()
                        thankYou()

                        titleTemplate()
                        sectionTitleTemplate()
                        defaultTemplate()
                        rightFrameTemplate()
                        leftFrameTemplate()
                        largeFrameTemplate()
                        highlightStatisticTemplate()
                        multipleContentTemplate()
                        multipleIconContentTemplate()
                        rightCustomContentTemplate()
                        fullCustomTemplate()
                        codeTemplate()
                        codeCustomContentTemplate()
                        thankYouTemplate()
                        introduction()
                        aboutKotlin()
                        map()
                        cameraViewFinder()
                    }
                }
            )
        }
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.scaledDp()),
            contentAlignment = Alignment.BottomCenter,
        ) {
            navigationBar()
        }
    }
}
