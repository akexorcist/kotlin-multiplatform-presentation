package com.akexorcist.kotlin.multiplatform.ui.content.maps

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.SwingPanel
import org.openstreetmap.gui.jmapviewer.Coordinate
import org.openstreetmap.gui.jmapviewer.JMapViewer
import org.openstreetmap.gui.jmapviewer.MapMarkerDot
import java.awt.Point
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.awt.event.MouseMotionAdapter

@Composable
actual fun MapContent(modifier: Modifier) {
    val bangkok = Coordinate(13.7563, 100.5018)
    val marker = remember { MapMarkerDot(bangkok) }
    val mapViewer = remember { JMapViewer() }
    var dragged by remember { mutableStateOf<Point?>(null) }

    Box(modifier = modifier) {
        SwingPanel(
            modifier = Modifier.fillMaxSize(),
            factory = {
                mapViewer.apply {
                    setDisplayPosition(bangkok, 18)
                    addMapMarker(marker)
                    addMouseListener(object : MouseAdapter() {
                        override fun mousePressed(event: MouseEvent) {
                            dragged = event.point
                        }

                        override fun mouseReleased(event: MouseEvent) {
                            dragged = null
                        }
                    })
                    addMouseMotionListener(object: MouseMotionAdapter() {
                        override fun mouseDragged(event: MouseEvent) {
                            dragged?.let { startPoint ->
                                val currentPoint = event.point
                                val diffX = startPoint.x - currentPoint.x
                                val diffY = startPoint.y - currentPoint.y
                                moveMap(diffX, diffY)
                                dragged = currentPoint
                            }
                        }
                    })
                }
            }
        )
    }
}
