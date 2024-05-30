package com.akexorcist.kotlin.multiplatform.ui.content.cameraviewfinder

import android.Manifest
import android.content.Context
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.akexorcist.kotlin.multiplatform.ui.theme.ContentColor
import com.markodevcic.peko.PermissionRequester
import com.markodevcic.peko.allGranted
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@Composable
actual fun CameraPreview(modifier: Modifier) {
    var isCameraPermissionGranted by remember { mutableStateOf(isCameraPermissionGranted()) }
    var isPermissionRequesting by remember { mutableStateOf(false) }

    LaunchedEffect(isCameraPermissionGranted) {
        if (isCameraPermissionGranted) return@LaunchedEffect
        if (isPermissionRequesting) return@LaunchedEffect
        isPermissionRequesting = true
        isCameraPermissionGranted = requestCameraPermission()
        isPermissionRequesting = false
    }
    if (isCameraPermissionGranted) {
        CameraViewFinder(modifier)
    } else {
        CircularProgressIndicator(
            modifier = Modifier.size(64.dp),
            color = ContentColor.Blue.color,
        )
    }
}

private fun isCameraPermissionGranted() = PermissionRequester.instance().areGranted(Manifest.permission.CAMERA)

private suspend fun requestCameraPermission(): Boolean = PermissionRequester.instance().request(Manifest.permission.CAMERA).allGranted()

@Composable
private fun CameraViewFinder(modifier: Modifier) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current
    val preview = Preview.Builder().build()
    val previewView = remember {
        PreviewView(context)
    }
    val cameraSelector = CameraSelector.Builder()
        .requireLensFacing(CameraSelector.LENS_FACING_FRONT)
        .build()

    LaunchedEffect(Unit) {
        val cameraProvider = context.getCameraProvider()
        cameraProvider.unbindAll()
        cameraProvider.bindToLifecycle(lifecycleOwner, cameraSelector, preview)
        preview.setSurfaceProvider(previewView.surfaceProvider)
    }

    AndroidView(
        factory = { previewView },
        modifier = Modifier
            .fillMaxSize()
            .then(modifier),
    )
}

private suspend fun Context.getCameraProvider(): ProcessCameraProvider =
    suspendCoroutine { continuation ->
        ProcessCameraProvider.getInstance(this).also { cameraProvider ->
            cameraProvider.get()
            cameraProvider.addListener(
                { continuation.resume(cameraProvider.get()) },
                ContextCompat.getMainExecutor(this),
            )
        }
    }