package com.soyaeeb.musicpartner.navigation.navigationdrawer

import com.soyaeeb.musicpartner.navigation.credential.CredentialConstant
import com.soyaeeb.musicpartner.navigation.navigationdrawer.util.DrawerConstants


sealed class DrawerItemScreen(val route: String){

    object ProfileScreen: DrawerItemScreen(DrawerConstants.PROFILE_SCREEN_ROUTE)
    object SettingsScreen: DrawerItemScreen(DrawerConstants.SETTINGS_SCREEN_ROUTE)
    object AboutScreen: DrawerItemScreen(DrawerConstants.ABOUT_SCREEN_ROUTE)
    object LogoutScreen: DrawerItemScreen(DrawerConstants.LOGOUT_SCREEN_ROUTE)
    object ExitScreen: DrawerItemScreen(DrawerConstants.EXIT_SCREEN_ROUTE)
    object TermsAndConditionsScreen: DrawerItemScreen(DrawerConstants.TERMS_AND_CONDITIONS_SCREEN_ROUTE)
}
