package com.soyaeeb.musicpartner.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.soyaeeb.musicpartner.ui.theme.primaryColor

@Composable
fun ChangeSystemColor() {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.isStatusBarVisible = false
        systemUiController.setStatusBarColor(
            color = primaryColor,
            darkIcons = false
        )
        systemUiController.setSystemBarsColor(
            color = primaryColor,
            darkIcons = false
        )
        systemUiController.setNavigationBarColor(
            color = primaryColor,
            darkIcons = false
        )
    }
}