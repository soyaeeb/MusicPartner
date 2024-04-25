package com.soyaeeb.musicpartner.navigation.root

import android.util.Log
import androidx.compose.runtime.State
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentManager.BackStackEntry
import androidx.navigation.*
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.soyaeeb.about.ui.AboutMainScreen
import com.soyaeeb.login.ui.LoginMainScreen
import com.soyaeeb.musicpartner.common.utility.model.BottomNavigationVisibilityState
import com.soyaeeb.musicpartner.navigation.credential.CredentialConstant
import com.soyaeeb.musicpartner.navigation.credential.CredentialScreen
import com.soyaeeb.musicpartner.navigation.navigationdrawer.DrawerItemScreen
import com.soyaeeb.musicpartner.navigation.root.util.RootGraphConstants
import com.soyaeeb.musicpartner.ui.MusicPartnerViewModel
import com.soyaeeb.profile.ui.ProfileMainScreen
import com.soyaeeb.settings.ui.SettingsMainScreen
import com.soyaeeb.termsconditions.ui.TermsAndConditionsMainScreen

fun NavGraphBuilder.navigationDrawerRootGraph(
    navController: NavHostController,
    musicPartnerViewModel: MusicPartnerViewModel,
    navigateToCredentialGraph: NavGraphBuilder.() -> Unit,
    backStackEntry: State<NavBackStackEntry?>
){
    navigation(
        route = RootGraphConstants.NAVIGATION_DRAWER_ROOT_ROUTE,
        startDestination = CredentialConstant.CREDENTIAL_ROOT_ROUTE
    ){
        navigateToCredentialGraph()
        composable(route = DrawerItemScreen.ProfileScreen.route){
            ProfileMainScreen(
                navigateBackToHomeScreen = {
                    navController.popBackStack()
                    musicPartnerViewModel.updateBottomNavigationVisibilityState(BottomNavigationVisibilityState.VISIBLE)
                }
            )
        }
        composable(route = DrawerItemScreen.SettingsScreen.route){
            SettingsMainScreen(
                navigateBackToHomeScreen = {
                    navController.popBackStack()
                    musicPartnerViewModel.updateBottomNavigationVisibilityState(BottomNavigationVisibilityState.VISIBLE)
                }
            )
        }
        composable(route = DrawerItemScreen.AboutScreen.route){
            AboutMainScreen(
                navigateBackToHomeScreen = {
                    navController.popBackStack()
                    musicPartnerViewModel.updateBottomNavigationVisibilityState(BottomNavigationVisibilityState.VISIBLE)
                }
            )
        }
        composable(
            route = DrawerItemScreen.TermsAndConditionsScreen.route,
            arguments = listOf(navArgument("fromDrawer"){type = NavType.BoolType})
        ){
            TermsAndConditionsMainScreen(
                navigateBackToHomeOrCreateAccountScreen = {
                    navController.popBackStack()
                   it.arguments?.getBoolean("fromDrawer")?.let {
                       if (it)musicPartnerViewModel.updateBottomNavigationVisibilityState(BottomNavigationVisibilityState.VISIBLE)
                       else  musicPartnerViewModel.updateBottomNavigationVisibilityState(BottomNavigationVisibilityState.INVISIBLE)
                   }
                }
            )
        }
    }
}