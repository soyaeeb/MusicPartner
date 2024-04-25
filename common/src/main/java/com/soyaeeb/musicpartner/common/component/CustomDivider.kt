package com.soyaeeb.musicpartner.common.component

import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Composable
fun CustomDivider(
    modifier : Modifier = Modifier,
    modifierThickness: Dp = DividerDefaults.Thickness,
    dividerColor: Color = Color.White
){
    Divider(
        modifier = modifier,
        thickness = modifierThickness,
        color = dividerColor,
    )
}