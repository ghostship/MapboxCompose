package com.inspiringapps.mapboxtest.library

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mapbox.common.MapboxOptions
import com.mapbox.geojson.Point
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.rememberMapViewportState

@Composable
actual fun MapboxMapView(accessToken: String, modifier: Modifier) {
    MapboxOptions.accessToken = accessToken

    MapboxMap(
        modifier = modifier,
        mapViewportState = rememberMapViewportState {
            setCameraOptions {
                zoom(2.0)
                center(Point.fromLngLat(-98.0, 39.5))
                pitch(0.0)
                bearing(0.0)
            }
        }
    )
}