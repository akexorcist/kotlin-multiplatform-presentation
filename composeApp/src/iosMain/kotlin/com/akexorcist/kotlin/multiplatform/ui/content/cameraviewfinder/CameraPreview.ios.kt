package com.akexorcist.kotlin.multiplatform.ui.content.cameraviewfinder

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import cocoapods.iosPreviewView.IOPreviewView
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import platform.AVFoundation.AVAuthorizationStatus
import platform.AVFoundation.AVAuthorizationStatusAuthorized
import platform.AVFoundation.AVAuthorizationStatusNotDetermined
import platform.AVFoundation.AVCaptureDevice
import platform.AVFoundation.AVCaptureDeviceInput
import platform.AVFoundation.AVCaptureDevicePositionFront
import platform.AVFoundation.AVCaptureDeviceTypeBuiltInWideAngleCamera
import platform.AVFoundation.AVCaptureSession
import platform.AVFoundation.AVCaptureSessionPresetHigh
import platform.AVFoundation.AVMediaTypeVideo
import platform.AVFoundation.authorizationStatusForMediaType
import platform.AVFoundation.defaultDeviceWithDeviceType
import platform.AVFoundation.requestAccessForMediaType

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun CameraPreview(modifier: Modifier) {
    val previewView = remember { IOPreviewView() }
    val coroutineScope = rememberCoroutineScope()
    val session = remember { AVCaptureSession() }
    var cameraAccessStatus by remember { mutableStateOf(CameraAccessStatus.Denied) }
    var videoDeviceInput by remember { mutableStateOf<AVCaptureDeviceInput?>(null) }

    DisposableEffect(cameraAccessStatus) {
        when (cameraAccessStatus) {
            CameraAccessStatus.Granted -> {
                coroutineScope.launch(Dispatchers.IO) {
                    videoDeviceInput = startVideoSession(session)
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

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        if (videoDeviceInput != null) {
            UIKitView(
                modifier = Modifier,
                interactive = true,
                factory = {
                    previewView.apply {
                        println("Set camera session")
                        setSession(session)
                    }
                },
                update = {
                }
            )
        } else {
            Text(text = "Camera is not available on this device.")
        }
    }
}

@OptIn(ExperimentalForeignApi::class)
private fun startVideoSession(session: AVCaptureSession): AVCaptureDeviceInput? {
    with(session) {
        beginConfiguration()
        sessionPreset = AVCaptureSessionPresetHigh
        val videoDevice = AVCaptureDevice.defaultDeviceWithDeviceType(
            deviceType = AVCaptureDeviceTypeBuiltInWideAngleCamera,
            mediaType = AVMediaTypeVideo,
            position = AVCaptureDevicePositionFront,
        ) ?: return null
        val videoDeviceInput = AVCaptureDeviceInput(videoDevice, null)
        if (canAddInput(videoDeviceInput)) {
            addInput(videoDeviceInput)
        } else return null
        commitConfiguration()
        startRunning()
        return videoDeviceInput
    }
}

private enum class CameraAccessStatus {
    Granted,
    Denied,
}