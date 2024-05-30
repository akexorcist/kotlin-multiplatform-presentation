package com.akexorcist.kotlin.multiplatform.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import com.akexorcist.kotlin.multiplatform.ui.content.App
import com.akexorcist.kotlin.multiplatform.ui.navigation.onNavigationKeyEvent
import com.akexorcist.kotlin.multiplatform.ui.navigation.rememberScreenNavigationState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                val screenNavigationState = rememberScreenNavigationState()
                Box(
                    modifier = Modifier.onNavigationKeyEvent(
                        onSpace = { screenNavigationState.next() },
                        onMetaRight = { screenNavigationState.last() },
                        onRight = { screenNavigationState.next() },
                        onMetaLeft = { screenNavigationState.first() },
                        onLeft = { screenNavigationState.back() },
                    )
                ) {
                    App(
                        screenNavigationState = screenNavigationState,
                    )
                }
            }
        }
    }
}
