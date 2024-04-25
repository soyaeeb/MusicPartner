package com.soyaeeb.createaccount.ui

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import com.soyaeeb.musicpartner.common.component.CommonTopAppBarWithBackButton

@Composable
fun CreateAccountMainScreen(
    navigateBackToLoginScreen: () -> Unit,
    navigateToHomeScreen: () -> Unit,
    navigateToTermsAndConditions: (Boolean) -> Unit
) {

    BackHandler { navigateBackToLoginScreen.invoke() }
    
    CommonTopAppBarWithBackButton(
        title = "Create Account",
        navigateBack = navigateBackToLoginScreen
    ) { innerPadding ->
        CreateAccountScreen(
            onSignUpClicked = { userName, emailOrPhone, password, confirmPassword, isTermsAndConditionsAccepted ->
                navigateToHomeScreen.invoke()
            },
            onTermsAndConditionsClicked = {navigateToTermsAndConditions.invoke(false)},
            onLoginClicked = navigateBackToLoginScreen,
            innerPadding = innerPadding
        )
    }

}



