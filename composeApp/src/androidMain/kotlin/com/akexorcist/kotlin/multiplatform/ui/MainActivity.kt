package com.akexorcist.kotlin.multiplatform.ui

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import com.akexorcist.kotlin.multiplatform.ui.content.App
import com.akexorcist.kotlin.multiplatform.ui.navigation.onNavigationKeyEvent
import com.akexorcist.kotlin.multiplatform.ui.navigation.rememberScreenNavigationState
import io.kamel.core.config.KamelConfig
import io.kamel.core.config.takeFrom
import io.kamel.image.config.Default
import io.kamel.image.config.LocalKamelConfig
import io.kamel.image.config.resourcesFetcher
import io.kamel.image.config.resourcesIdMapper

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                val context: Context = LocalContext.current
                val androidConfig = KamelConfig {
                    takeFrom(KamelConfig.Default)
                    resourcesFetcher(context)
                    resourcesIdMapper(context)
                }
                val screenNavigationState = rememberScreenNavigationState()
                CompositionLocalProvider(
                    value = LocalKamelConfig provides androidConfig
                ) {
                    Box(
                        modifier = Modifier
                            .onNavigationKeyEvent(
                                onSpace = { screenNavigationState.next() },
                                onMetaRight = { screenNavigationState.last() },
                                onRight = { screenNavigationState.next() },
                                onMetaLeft = { screenNavigationState.first() },
                                onLeft = { screenNavigationState.back() },
                            )
                            .pointerInput(Unit) {
                                detectTapGestures(
                                    onTap = { screenNavigationState.next() },
                                    onLongPress = { screenNavigationState.back() }
                                )
                            }
                    ) {
                        App(
                            screenNavigationState = screenNavigationState,
                        )
                    }
                }
            }
        }
    }
}
