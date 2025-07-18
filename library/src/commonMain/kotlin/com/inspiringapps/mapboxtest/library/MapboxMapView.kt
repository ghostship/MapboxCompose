package com.inspiringapps.mapboxtest.library

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun MapboxMapView(accessToken: String, modifier: Modifier = Modifier)