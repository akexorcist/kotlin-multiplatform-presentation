package com.akexorcist.kotlin.multiplatform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.akexorcist.kotlin.multiplatform.ui.feature.App
import com.akexorcist.kotlin.multiplatform.ui.navigation.rememberScreenNavigationState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val screenNavigationState = rememberScreenNavigationState()
            App(
                screenNavigationState = screenNavigationState,
            )
        }
    }
}
