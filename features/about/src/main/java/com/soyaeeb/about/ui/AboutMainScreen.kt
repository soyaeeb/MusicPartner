package com.soyaeeb.about.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import com.soyaeeb.assets.R
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import com.soyaeeb.musicpartner.common.component.CommonTopAppBarWithBackButton

@Composable
fun AboutMainScreen(
    navigateBackToHomeScreen: () -> Unit
) {
    BackHandler { navigateBackToHomeScreen.invoke() }
    CommonTopAppBarWithBackButton(
        title = "About",
        navigateBack = navigateBackToHomeScreen
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(colorResource(id = R.color.custom_background_color)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "About Screen",
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}



