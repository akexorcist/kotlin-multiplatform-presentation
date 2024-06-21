package com.akexorcist.kotlin.multiplatform.ui.content.camera

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.layout.ContentScale
import com.akexorcist.kotlin.multiplatform.ui.theme.ContentColor
import com.akexorcist.kotlin.multiplatform.ui.theme.scaledDp
import com.github.eduramiba.webcamcapture.drivers.NativeDriver
import com.github.sarxos.webcam.Webcam
import com.github.sarxos.webcam.WebcamEvent
import com.github.sarxos.webcam.WebcamListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@Composable
actual fun CameraPreview(modifier: Modifier) {
    val coroutineScope = rememberCoroutineScope()
    val cameraManager = remember { CameraManager() }
    val image by cameraManager.image.collectAsState()

    DisposableEffect(cameraManager) {
        coroutineScope.launch(Dispatchers.Default) { cameraManager.open() }
        onDispose { cameraManager.close() }
    }
    image?.let {
        Image(
            modifier = modifier.fillMaxSize(),
            bitmap = it,
            contentDescription = "image from camera",
            contentScale = ContentScale.Crop,
        )
    } ?: run {
        CircularProgressIndicator(
            modifier = Modifier.size(64.scaledDp()),
            color = ContentColor.Blue.color,
        )
    }
}

private class CameraManager {
    private var _image: MutableStateFlow<ImageBitmap?> = MutableStateFlow(null)
    val image: StateFlow<ImageBitmap?> = _image

    private var _status: MutableStateFlow<CameraStatus> = MutableStateFlow(CameraStatus.Closed)
    val status: StateFlow<CameraStatus> = _status

    private var currentCamera: Webcam? = null

    suspend fun open() {
        runCatching {
            Webcam.setDriver(NativeDriver())
            Webcam.getDefault()
        }.getOrNull()?.apply {
            this@apply.close()
            while (isOpen || lock.isLocked) {
                delay(100L)
            }
            device.resolutions.getOrNull(0)?.let { resolution ->
                device.resolution = resolution
            }
            addWebcamListener(webcamListener)
            open(true)
            currentCamera = this
        }
    }

    fun close() {
        currentCamera?.apply {
            close()
            removeWebcamListener(webcamListener)
        }
        currentCamera = null
    }

    private val webcamListener = object : WebcamListener {
        override fun webcamOpen(event: WebcamEvent?) {
            _status.update { CameraStatus.Opened }
        }

        override fun webcamClosed(event: WebcamEvent?) {
            _status.update { CameraStatus.Closed }
        }

        override fun webcamDisposed(event: WebcamEvent?) {
            _status.update { CameraStatus.Closed }
        }

        override fun webcamImageObtained(event: WebcamEvent?) {
            event?.image?.toComposeImageBitmap()?.let { bitmap ->
                _image.update { bitmap }
            }
        }
    }
}

private enum class CameraStatus {
    Opened,
    Closed,
}