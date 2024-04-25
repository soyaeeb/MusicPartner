package com.soyaeeb.musicpartner.navigation.navigationdrawer

import androidx.compose.runtime.Composable

data class DrawerItem(
    val title: String,
    val route: String,
    val contentDescription: String,
    val icon: (@Composable () -> Unit)
)