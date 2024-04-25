package com.soyaeeb.musicpartner.common.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.soyaeeb.assets.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonTopAppBarWithBackButton (
    title: String,
    navigateBack: () -> Unit,
    showScreen: @Composable (innerPadding: PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(colorResource(id = R.color.primaryColor)),
                title = {
                    Text(
                        text = title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navigateBack.invoke() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back Arrow Icon",
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ){ innerPadding ->
        showScreen(innerPadding =  innerPadding)
    }
}