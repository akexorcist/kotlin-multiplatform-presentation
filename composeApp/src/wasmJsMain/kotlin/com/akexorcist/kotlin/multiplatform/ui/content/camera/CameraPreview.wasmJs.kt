package com.akexorcist.kotlin.multiplatform.ui.content.camera

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.await
import kotlinx.coroutines.launch
import org.w3c.dom.Document
import org.w3c.dom.HTMLVideoElement
import org.w3c.dom.events.Event
import org.w3c.dom.mediacapture.MediaStream
import org.w3c.dom.mediacapture.MediaStreamConstraints
import org.w3c.files.Blob

private fun Document.getCameraElement() = this.getElementById("camera") as? HTMLVideoElement

@Composable
actual fun CameraPreview(modifier: Modifier) {
    val coroutineScope = rememberCoroutineScope()
    var stream: MediaStream? by remember { mutableStateOf(null) }

    DisposableEffect(Unit) {
        coroutineScope.launch {
            stream = window.navigator
                .mediaDevices
                .getUserMedia(MediaStreamConstraints(video = true.toJsBoolean()))
                .await<MediaStream>()
        }
        onDispose {
            document.getCameraElement()?.style?.display = "none"
            stream?.getVideoTracks()?.let { tracks ->
                for (index in 0 until tracks.length) {
                    tracks[index]?.stop()
                }
            }
            stream = null
        }
    }

    LaunchedEffect(stream) {
        val mediaStream = stream ?: return@LaunchedEffect
        println(mediaStream)
        document.getCameraElement()?.let { element ->
            element.srcObject = mediaStream
            element.style.removeProperty("display")

            element.addEventListener("canplay") { _ ->
                element.play()
                element.removeEventListener("canplay", null as ((Event) -> Unit)?)
            }
        }
    }
}

@Composable
private fun CameraPreview2(modifier: Modifier) {
    val coroutineScope = rememberCoroutineScope()
    var stream: MediaStream? by remember { mutableStateOf(null) }

    DisposableEffect(Unit) {
        coroutineScope.launch {
            stream = window.navigator
                .mediaDevices
                .getUserMedia(MediaStreamConstraints(video = true.toJsBoolean()))
                .await<MediaStream>()
        }
        onDispose {
            stream?.getVideoTracks()?.let { tracks ->
                for (index in 0 until tracks.length) {
                    tracks[index]?.stop()
                }
            }
            stream = null
        }
    }

    LaunchedEffect(stream) {
        val mediaStream = stream ?: return@LaunchedEffect
        println(mediaStream)
        document.getCameraElement()?.let { element ->
            coroutineScope.launch {
                val blob = imageFromMediaStream(mediaStream).await<Blob>()
                println("Result from convertStreamToByteArray: ${blob.type}, ${blob.size}")
            }
        }
    }
}
