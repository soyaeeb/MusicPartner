package com.soyaeeb.musicpartner.navigation.root


import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.soyaeeb.createaccount.ui.CreateAccountMainScreen
import com.soyaeeb.login.ui.LoginMainScreen
import com.soyaeeb.musicpartner.common.utility.model.BottomNavigationVisibilityState
import com.soyaeeb.musicpartner.navigation.credential.CredentialConstant
import com.soyaeeb.musicpartner.navigation.credential.CredentialScreen
import com.soyaeeb.musicpartner.navigation.navigationdrawer.DrawerItemScreen
import com.soyaeeb.musicpartner.navigation.root.util.RootGraphConstants
import com.soyaeeb.musicpartner.ui.MusicPartnerViewModel

fun NavGraphBuilder.credentialRootGraph(
    navController: NavHostController,
    musicPartnerViewModel: MusicPartnerViewModel,
) {
    navigation(
        route = CredentialConstant.CREDENTIAL_ROOT_ROUTE,
        startDestination = CredentialScreen.LoginScreen.route
    ) {
        composable(route = CredentialScreen.LoginScreen.route) {
            LoginMainScreen(
                navigateBackToHomeScreen = {
                    navController.popBackStack()
                    musicPartnerViewModel.updateBottomNavigationVisibilityState(
                        BottomNavigationVisibilityState.VISIBLE
                    )
                },
                navigateToCreateAccountScreen = {
                    musicPartnerViewModel.updateBottomNavigationVisibilityState(
                        BottomNavigationVisibilityState.INVISIBLE
                    )
                    navController.navigate(CredentialScreen.CreateAccountScreen.route)
                }
            )
        }

        composable(route = CredentialScreen.CreateAccountScreen.route) {
            CreateAccountMainScreen(
                navigateBackToLoginScreen = {
                    navController.popBackStack()
                    musicPartnerViewModel.updateBottomNavigationVisibilityState(BottomNavigationVisibilityState.INVISIBLE)
                },
                navigateToHomeScreen = {
                    navController.navigate(RootGraphConstants.BOTTOM_NAVIGATION_ROOT_ROUTE) {
                       popUpTo(RootGraphConstants.NAVIGATION_DRAWER_ROOT_ROUTE){
                           saveState = true
                       }
                        launchSingleTop = true
                        restoreState = true
                    }
                    musicPartnerViewModel.updateBottomNavigationVisibilityState(BottomNavigationVisibilityState.VISIBLE)
                },
                navigateToTermsAndConditions = {
                    navController.navigate("TERMS_AND_CONDITIONS_SCREEN_ROUTE/$it")
                }
            )
        }
    }
}