package com.soyaeeb.musicpartner.common.component

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

@Composable
fun LoadingScreen() {
    Box(contentAlignment = Alignment.Center) {
        CustomCircularProgressIndicator()
    }
}