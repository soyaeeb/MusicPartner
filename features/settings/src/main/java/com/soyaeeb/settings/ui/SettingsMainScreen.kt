package com.soyaeeb.settings.ui

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.*
import com.soyaeeb.musicpartner.common.component.CommonTopAppBarWithBackButton

@Composable
fun SettingsMainScreen(
    navigateBackToHomeScreen: () -> Unit
) {
    BackHandler { navigateBackToHomeScreen.invoke() }
    CommonTopAppBarWithBackButton(
        title = "Settings",
        navigateBack = navigateBackToHomeScreen
    ) { innerPadding ->
        SettingsScreen(
            onThemeChosen = {

            },
            onLanguageChosen = {

            },
            innerPadding = innerPadding
        )
    }
}



