package com.soyaeeb.musicpartner.common.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.soyaeeb.assets.R

@Composable
fun DefaultScreen(
    imagePainter: Painter = painterResource(id = R.drawable.ic_sad_imoji),
    imageContentDescription: String = "Sad Imoji Logo",
    infoText: String,
    infoTextSize: Int = 20,
    infoTextStyle: FontStyle = FontStyle.Normal,
    infoTextWeight: FontWeight = FontWeight.Bold,
    infoTextColor: Color = Color.White,
    spacerHeight: Dp = 30.dp
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = imagePainter,
            contentDescription = imageContentDescription,
        )
        Spacer(modifier = Modifier.height(spacerHeight))
        Text(
            text = infoText,
            fontSize =infoTextSize.sp,
            fontStyle = infoTextStyle,
            fontWeight = infoTextWeight,
            color = infoTextColor
        )
    }
}