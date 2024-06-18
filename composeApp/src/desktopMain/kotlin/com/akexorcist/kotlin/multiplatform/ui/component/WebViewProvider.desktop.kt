package com.akexorcist.kotlin.multiplatform.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.akexorcist.kotlin.multiplatform.ui.theme.ContentColor
import dev.datlag.kcef.KCEF
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import kotlin.math.max

@Composable
actual fun WebViewProvider(
    content: @Composable () -> Unit
) {
    var restartRequired by remember { mutableStateOf(false) }
    var progress by remember { mutableStateOf(0F) }
    var initialized by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            KCEF.init(
                builder = {
                    installDir(File("kcef-bundle"))
                    progress {
                        onDownloading { progress = max(it, 0F) }
                        onInitialized { initialized = true }
                    }
                    release("jbr-release-17.0.10b1087.23")
                    settings { cachePath = File("cache").absolutePath }
                },
                onError = { it?.printStackTrace() },
                onRestartRequired = { restartRequired = true },
            )
        }
    }

//    LaunchedEffect(Unit) {
//        withContext(Dispatchers.IO) {
//            Cef.init(builder = {
//                installDir = File("jcef-bundle")
//                settings {
//                    cachePath = File("cache").absolutePath
//                }
//            }, initProgress = {
//                onDownloading {
//                    progress = max(it, 0F)
//                }
//                onInitialized {
//                    initialized = true
//                }
//            }, onError = {
//                it.printStackTrace()
//            }, onRestartRequired = {
//                restartRequired = true
//            })
//        }
//    }
//    DisposableEffect(Unit) {
//        onDispose {
//            Cef.dispose()
//        }
//    }

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            !initialized -> Loading(progress.toInt())
            restartRequired -> RestartRequired(
                onRestartClicked = {}
            )

            else -> content()
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            KCEF.disposeBlocking()
        }
    }
}

@Composable
private fun BoxScope.Loading(progress: Int) {
    Column(
        modifier = Modifier.align(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(64.dp),
            color = ContentColor.Blue.color,
        )
        Spacer(modifier = Modifier.height(16.dp))
        ContentText(
            text = "Downloading (${progress}%)",
        )
    }
}

@Composable
private fun BoxScope.RestartRequired(onRestartClicked: () -> Unit) {
    Column(
        modifier = Modifier.align(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ContentText(
            text = "Please restart to apply changes for WebView",
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onRestartClicked) {
            Text(text = "Restart")
        }
    }
}
