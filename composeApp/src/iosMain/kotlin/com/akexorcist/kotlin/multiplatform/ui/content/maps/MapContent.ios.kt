package com.akexorcist.kotlin.multiplatform.ui.content.maps

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import cocoapods.GoogleMaps.GMSCameraPosition
import cocoapods.GoogleMaps.GMSMapView
import cocoapods.GoogleMaps.GMSMapViewDelegateProtocol
import cocoapods.GoogleMaps.GMSMarker
import kotlinx.cinterop.ExperimentalForeignApi
import platform.CoreLocation.CLLocationCoordinate2DMake
import platform.darwin.NSObject

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun MapContent(modifier: Modifier) {
    val bangkok = remember { Pair(13.7563, 100.5018) }
    val googleMapView = remember {
        GMSMapView().apply {
            setMyLocationEnabled(false)
            settings.myLocationButton = false
        }
    }
    val marker = remember {
        GMSMarker().apply {
            val (latitude, longitude) = bangkok
            this.position = CLLocationCoordinate2DMake(latitude, longitude)
            this.title = "Bangkok"
            this.map = googleMapView
        }
    }
    val delegate = remember {
        object : NSObject(), GMSMapViewDelegateProtocol {
//            override fun mapView(
//                mapView: GMSMapView,
//                @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE") didTapMarker: GMSMarker,
//            ): Boolean {
//                println("User tap on marker (${didTapMarker.userData()})")
//                return true
//            }
        }
    }

    Box(modifier = modifier.fillMaxSize()) {
        UIKitView(
            modifier = Modifier.fillMaxSize(),
            interactive = true,
            factory = {
                googleMapView.apply {
                    setDelegate(delegate)
                    camera = GMSCameraPosition.cameraWithLatitude(
                        latitude = bangkok.first,
                        longitude = bangkok.second,
                        zoom = 18f,
                    )
                }
            },
            update = {},
        )
    }
}
