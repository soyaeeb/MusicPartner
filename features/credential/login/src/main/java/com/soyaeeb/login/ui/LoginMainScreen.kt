package com.soyaeeb.login.ui

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import com.soyaeeb.musicpartner.common.component.CommonTopAppBarWithBackButton

@Composable
fun LoginMainScreen(
    navigateBackToHomeScreen: () -> Unit,
    navigateToCreateAccountScreen: () -> Unit
) {

    BackHandler { navigateBackToHomeScreen.invoke() }
    
    CommonTopAppBarWithBackButton(
        title = "Login",
        navigateBack = navigateBackToHomeScreen
    ) { innerPadding ->

        LoginScreen(
            onLoginButtonClicked = { phoneNumberOrGmail, password ->

            },
            onCreateAccountClicked = navigateToCreateAccountScreen,
            onContinueWithGoogleClicked = {

            },
            onContinueWithFacebookClicked = {

            },
            innerPadding = innerPadding
        )
    }

}



