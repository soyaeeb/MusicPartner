package com.soyaeeb.musicpartner.common.component

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Composable
fun CustomCircularProgressIndicator(
    modifier: Modifier = Modifier,
    IndicatorColor: Color = Color.White,
    strokeWidth: Dp = ProgressIndicatorDefaults.CircularStrokeWidth
){
    CircularProgressIndicator(
        modifier = modifier,
        color = IndicatorColor,
        strokeWidth = strokeWidth
    )
}