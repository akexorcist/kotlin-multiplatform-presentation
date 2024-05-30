@file:JsModule("./media-recorder.js")

package com.akexorcist.kotlin.multiplatform.ui.content.cameraviewfinder

import kotlin.js.Promise

external fun imageFromMediaStream(mediaStream: JsAny): Promise<JsAny>
