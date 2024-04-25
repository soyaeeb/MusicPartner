package com.soyaeeb.musicpartner.navigation.navigationdrawer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.ui.res.painterResource
import com.soyaeeb.assets.R
import com.soyaeeb.musicpartner.navigation.credential.CredentialScreen
import com.soyaeeb.musicpartner.navigation.navigationdrawer.util.DrawerConstants

object DrawerBody {
    val itemsList = listOf(
        DrawerItem(
            route = CredentialScreen.LoginScreen.route,
            title = DrawerConstants.ACCOUNT_ITEM_TITLE,
            contentDescription = DrawerConstants.ACCOUNT_ITEM_CONTENT_DESCRIPTION,
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_account),
                    contentDescription = DrawerConstants.ACCOUNT_ITEM_CONTENT_DESCRIPTION
                )
            }
        ),
        DrawerItem(
            route = DrawerItemScreen.ProfileScreen.route,
            title = DrawerConstants.PROFILE_ITEM_TITLE,
            contentDescription = DrawerConstants.PROFILE_ITEM_CONTENT_DESCRIPTION,
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = DrawerConstants.PROFILE_ITEM_CONTENT_DESCRIPTION
                )
            }
        ),
        DrawerItem(
            title = DrawerConstants.SETTINGS_ITEM_TITLE,
            route = DrawerItemScreen.SettingsScreen.route,
            contentDescription = DrawerConstants.SETTINGS_ITEM_CONTENT_DESCRIPTION,
            icon = {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription =  DrawerConstants.SETTINGS_ITEM_CONTENT_DESCRIPTION
                )
            }
        ),
        DrawerItem(
            title = DrawerConstants.ABOUT_ITEM_TITLE,
            route = DrawerItemScreen.AboutScreen.route,
            contentDescription = DrawerConstants.ABOUT_ITEM_CONTENT_DESCRIPTION,
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_about),
                    contentDescription = DrawerConstants.ABOUT_ITEM_CONTENT_DESCRIPTION
                )
            }
        ),
        DrawerItem(
            title = DrawerConstants.LOGOUT_ITEM_TITLE,
            route = DrawerItemScreen.LogoutScreen.route,
            contentDescription = DrawerConstants.LOGOUT_ITEM_CONTENT_DESCRIPTION,
            icon = {
                Icon(
                    imageVector = Icons.Default.Logout,
                    contentDescription = DrawerConstants.LOGOUT_ITEM_CONTENT_DESCRIPTION
                )
            }
        ),
        DrawerItem(
            route = DrawerItemScreen.TermsAndConditionsScreen.route,
            title = DrawerConstants.TERMS_AND_CONDITIONS_ITEM_TITLE,
            contentDescription = DrawerConstants.TERMS_AND_CONDITIONS_ITEM_CONTENT_DESCRIPTION,
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_terms_and_conditions),
                    contentDescription = DrawerConstants.TERMS_AND_CONDITIONS_ITEM_CONTENT_DESCRIPTION
                )
            }
        ),
        DrawerItem(
            title = DrawerConstants.EXIT_ITEM_TITLE,
            route = DrawerItemScreen.ExitScreen.route,
            contentDescription = DrawerConstants.EXIT_ITEM_CONTENT_DESCRIPTION,
            icon = {
                Icon(
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = DrawerConstants.EXIT_ITEM_CONTENT_DESCRIPTION
                )
            }
        )
    )
}

