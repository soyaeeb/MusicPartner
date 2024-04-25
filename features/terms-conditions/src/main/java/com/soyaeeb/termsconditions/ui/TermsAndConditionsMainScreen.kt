package com.soyaeeb.termsconditions.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import com.soyaeeb.assets.R
import com.soyaeeb.musicpartner.common.component.CommonTopAppBarWithBackButton

@Composable
fun TermsAndConditionsMainScreen(
    navigateBackToHomeOrCreateAccountScreen: () -> Unit
) {
    BackHandler { navigateBackToHomeOrCreateAccountScreen.invoke() }
    CommonTopAppBarWithBackButton(
        title = "Terms & Conditions",
        navigateBack = navigateBackToHomeOrCreateAccountScreen
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
                text = "Terms And Conditions Screen",
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}



