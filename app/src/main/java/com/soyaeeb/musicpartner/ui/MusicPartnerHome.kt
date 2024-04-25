package com.soyaeeb.musicpartner.ui

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.soyaeeb.musicpartner.common.component.ExitAlertDialog
import com.soyaeeb.musicpartner.common.utility.model.BottomNavigationVisibilityState
import com.soyaeeb.musicpartner.common.utility.permission.RequestSinglePermission
import com.soyaeeb.musicpartner.navigation.credential.CredentialScreen
import com.soyaeeb.musicpartner.navigation.navigationdrawer.DrawerItemScreen
import com.soyaeeb.musicpartner.navigation.navigationdrawer.NavigationDrawer
import com.soyaeeb.musicpartner.ui.theme.MusicPartnerTheme
import com.soyaeeb.musicpartner.util.ChangeSystemColor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MusicPartnerHome : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChangeSystemColor()
            val context = LocalContext.current
            MusicPartnerTheme {
                RequestPermission(context = context)
            }
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
private fun RequestPermission(
    context: Context
) {
    var hasPermission by remember { mutableStateOf(false) }
    var shouldShowExitDialog by remember { mutableStateOf(false) }
    val viewModel = hiltViewModel<MusicPartnerViewModel>()
    val activity = LocalContext.current as Activity

    RequestSinglePermission(
        context = context,
        permission = Manifest.permission.READ_EXTERNAL_STORAGE,
        rationalMessage = "External Permission is Needed to Listen Your Favourite Song",
        onPermissionGranted = { hasPermission = true },
    )
    if (hasPermission) {
        val navController = rememberNavController()

        NavigationDrawer(
            navController = navController,
            navigateToLoginScreen = {
                viewModel.updateBottomNavigationVisibilityState(BottomNavigationVisibilityState.INVISIBLE)
                navController.navigate(route = CredentialScreen.LoginScreen.route)
            },
            navigateToProfileScreen = {
                viewModel.updateBottomNavigationVisibilityState(BottomNavigationVisibilityState.INVISIBLE)
                navController.navigate(route = DrawerItemScreen.ProfileScreen.route)
            },
            navigateToSettingsScreen = {
                viewModel.updateBottomNavigationVisibilityState(BottomNavigationVisibilityState.INVISIBLE)
                navController.navigate(route = DrawerItemScreen.SettingsScreen.route)
            },
            navigateToAboutScreen = {
                viewModel.updateBottomNavigationVisibilityState(BottomNavigationVisibilityState.INVISIBLE)
                navController.navigate(route = DrawerItemScreen.AboutScreen.route)
            },
            navigateToTermsAndConditionsScreen = {
                viewModel.updateBottomNavigationVisibilityState(BottomNavigationVisibilityState.INVISIBLE)
                navController.navigate(route = "TERMS_AND_CONDITIONS_SCREEN_ROUTE/$it")
            },
            logoutFromSystem = {},
            showExitDialog = { shouldShowExitDialog = true }
        )

        if (shouldShowExitDialog) {
            ExitAlertDialog(
                onConfirmButtonClick = { activity.finish() },
                onCancelButtonClick = { shouldShowExitDialog = false },
                onDismissRequest = { shouldShowExitDialog = false }
            )
        }
    }
}




