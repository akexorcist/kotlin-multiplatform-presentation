package com.akexorcist.kotlin.multiplatform.ui.content.cameraviewfinder

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import platform.AVFoundation.AVAuthorizationStatus
import platform.AVFoundation.AVAuthorizationStatusAuthorized
import platform.AVFoundation.AVAuthorizationStatusNotDetermined
import platform.AVFoundation.AVCaptureDevice
import platform.AVFoundation.AVCaptureSession
import platform.AVFoundation.AVMediaTypeVideo
import platform.AVFoundation.authorizationStatusForMediaType
import platform.AVFoundation.requestAccessForMediaType
import platform.UIKit.UIView

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun CameraPreview(modifier: Modifier) {
//    val previewView = remember {
//        CaptureSessionPreview()
//    }

    val coroutineScope = rememberCoroutineScope()
    val session = remember { AVCaptureSession() }
    var cameraAccessStatus by remember { mutableStateOf(CameraAccessStatus.Denied) }

    DisposableEffect(cameraAccessStatus) {
        when (cameraAccessStatus) {
            CameraAccessStatus.Granted -> {
                println("startRunning")
                coroutineScope.launch(Dispatchers.IO) {
                    session.startRunning()
                }
                onDispose {
//                    coroutineScope.launch(Dispatchers.IO) {
//                        if (session.isRunning()) {
//                            println("stopRunning")
//                            session.stopRunning()
//                        }
//                    }
                }
            }

            CameraAccessStatus.Denied -> {
                onDispose { }
            }
        }
    }

    LaunchedEffect(Unit) {
        val status: AVAuthorizationStatus = AVCaptureDevice.authorizationStatusForMediaType(AVMediaTypeVideo)
        when (status) {
            AVAuthorizationStatusAuthorized -> cameraAccessStatus = CameraAccessStatus.Granted
            AVAuthorizationStatusNotDetermined -> {
                AVCaptureDevice.requestAccessForMediaType(AVMediaTypeVideo) { isGranted ->
                    cameraAccessStatus = when (isGranted) {
                        true -> CameraAccessStatus.Granted
                        false -> CameraAccessStatus.Denied
                    }
                }
            }

            else -> cameraAccessStatus = CameraAccessStatus.Denied
        }
    }

    Column(modifier) {
//        UIKitView(
//            modifier = Modifier,
//            interactive = true,
//            factory = {
//                previewView
//            },
//            update = {
//
//            }
//        )
        Awesome()
    }
}

@OptIn(ExperimentalForeignApi::class)
@Composable
fun Awesome(modifier: Modifier = Modifier) {
    UIKitView(
        modifier = modifier,
        interactive = false,
        factory = {
            UIView().apply {

            }
        },
    )
}

private enum class CameraAccessStatus {
    Granted,
    Denied,
}