@file:OptIn(ExperimentalForeignApi::class)

package com.inspiringapps.mapboxtest.library

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.UIKitView
import cocoapods.MapboxWrapper.MapboxMapViewWrapper
import kotlinx.cinterop.ExperimentalForeignApi
import platform.CoreGraphics.CGRectMake

val wrapper = MapboxMapViewWrapper()

@Composable
actual fun MapboxMapView(accessToken: String, modifier: Modifier) {
    UIKitView(
        factory = {
            wrapper.createMapViewWithBounds(
                bounds = CGRectMake(0.0, 0.0, 0.0, 0.0),
                token = accessToken
            )
        },
        modifier = modifier,
        update = { mapView -> }
    )
}